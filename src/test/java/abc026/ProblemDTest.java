package abc026;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() throws IOException {
		check(1, 1, 1);
	}

	@Test
	void case2() throws IOException {
		check(53, 82, 49);
	}

	private void check(int a, int b, int c) throws IOException {
		in.input(a + " " + b + " " + c);
		ProblemD.main(null);
		try (ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			double t = scanner.nextDouble();
			assertTrue(Math.abs(a * t + b * Math.sin(c * t * Math.PI) - 100.0d) < 0.000001d);
		}
	}
}
