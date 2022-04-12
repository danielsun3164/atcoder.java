package abc.abc001_050.abc026;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		check(1, 1, 1);
	}

	@Test
	void case2() {
		check(53, 82, 49);
	}

	private void check(int a, int b, int c) {
		in.input(a + " " + b + " " + c);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			double t = scanner.nextDouble();
			assertNumberIsAbout(100.d, a * t + b * Math.sin(c * t * Math.PI), TOLERANCE);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
