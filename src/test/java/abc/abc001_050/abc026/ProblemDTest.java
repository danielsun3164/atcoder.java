package abc.abc001_050.abc026;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

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
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			double t = scanner.nextDouble();
			assertTrue(Math.abs(a * t + b * Math.sin(c * t * Math.PI) - 100.0d) < 0.000001d,
					"value is " + (a * t + b * Math.sin(c * t * Math.PI)));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
