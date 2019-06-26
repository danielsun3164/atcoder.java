package abc026;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() throws IOException {
		int a = 1;
		int b = 1;
		int c = 1;
		in.input(a + " " + b + " " + c);
		ProblemD.main(null);
		try (ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			double t = scanner.nextDouble();
			assertTrue(Math.abs(a * t + b * Math.sin(c * t * Math.PI) - 100.0d) < 0.000001d);
		}
	}

	@Test
	void test_Case2() throws IOException {
		int a = 53;
		int b = 82;
		int c = 49;
		in.input(a + " " + b + " " + c);
		ProblemD.main(null);
		try (ByteArrayInputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			double t = scanner.nextDouble();
			assertTrue(Math.abs(a * t + b * Math.sin(c * t * Math.PI) - 100.0d) < 0.000001d);
		}
	}
}
