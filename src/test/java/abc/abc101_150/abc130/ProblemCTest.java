package abc.abc101_150.abc130;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-9d;

	@Test
	void case1() {
		check("2 3 1 2", 3.0000000d, 0);
	}

	@Test
	void case2() {
		check("2 2 1 1", 2.0000000d, 1);
	}

	private void check(String s, double d, int n) {
		in.input(s);
		ProblemC.main(null);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			double result1 = scanner.nextDouble();
			int result2 = scanner.nextInt();
			assertTrue(Math.abs(result1 - d) < TOLERANCE, "result is " + result1);
			assertEquals(n, result2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
