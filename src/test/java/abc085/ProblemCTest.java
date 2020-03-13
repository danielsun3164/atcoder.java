package abc085;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() throws IOException {
		int n = 9;
		int y = 45000;
		in.input(n + " " + y);
		ProblemC.main(null);
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			assertTrue(n == (a + b + c));
			assertTrue(y == (a * 10000 + b * 5000 + c * 1000));
		}
	}

	@Test
	void case2() {
		in.input("20 196000");
		ProblemC.main(null);
		assertResultIs("-1 -1 -1");
	}

	@Test
	void case3() throws IOException {
		int n = 1000;
		int y = 1234000;
		in.input(n + " " + y);
		ProblemC.main(null);
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			assertTrue(n == (a + b + c));
			assertTrue(y == (a * 10000 + b * 5000 + c * 1000));
		}
	}

	@Test
	void case4() {
		in.input("2000 20000000");
		ProblemC.main(null);
		assertResultIs("2000 0 0");
	}
}
