package abc021;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() throws IOException {
		int n = 5;
		in.input(n);
		ProblemA.main(null);
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			int number = scanner.nextInt();
			int sum = IntStream.range(0, number).map(i -> scanner.nextInt()).sum();
			assertEquals(n, sum);
		}
	}

	@Test
	void test_Case2() throws IOException {
		int n = 1;
		in.input(n);
		ProblemA.main(null);
		try (PipedOutputStream pos = new PipedOutputStream();
				PipedInputStream pis = new PipedInputStream(pos);
				Scanner scanner = new Scanner(pis)) {
			out.writeTo(pos);
			int number = scanner.nextInt();
			int sum = IntStream.range(0, number).map(i -> scanner.nextInt()).sum();
			assertEquals(n, sum);
		}
	}
}
