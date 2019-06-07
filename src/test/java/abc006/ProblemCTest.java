package abc006;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() throws IOException {
		int n = 3;
		int m = 9;
		in.input(n + " " + m);
		ProblemC.main(null);
		try (ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int a1 = scanner.nextInt();
			int a2 = scanner.nextInt();
			int a3 = scanner.nextInt();
			assertEquals(n, a1 + a2 + a3);
			assertEquals(m, a1 * 2 + a2 * 3 + a3 * 4);
		}
	}

	@Test
	void test_Case2() throws IOException {
		int n = 7;
		int m = 23;
		in.input(n + " " + m);
		ProblemC.main(null);
		try (ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int a1 = scanner.nextInt();
			int a2 = scanner.nextInt();
			int a3 = scanner.nextInt();
			assertEquals(n, a1 + a2 + a3);
			assertEquals(m, a1 * 2 + a2 * 3 + a3 * 4);
		}
	}

	@Test
	void test_Case3() {
		in.input("10 41");
		ProblemC.main(null);
		assertResultIs("-1 -1 -1");
	}
}
