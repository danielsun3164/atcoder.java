package abc.abc151_200.abc197;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 10E-5d;

	@Test
	void case1() {
		check(4, 1, 1, 2, 2, 2.0d, 1.0d);
	}

	@Test
	void case2() {
		check(6, 5, 3, 7, 4, 5.93301270189d, 2.38397459622d);
	}

	@Test
	void case3() {
		check(4, 1, 1, 1, 2, 1.5d, 1.5d);
	}

	@Test
	void case4() {
		check(4, 1, 1, 0, 2, 1.0d, 2.0d);
	}

	@Test
	void case5() {
		check(4, 1, 1, 0, 0, 0.0d, 1.0d);
	}

	@Test
	void case6() {
		check(4, 1, 1, 0, 2, 1.0d, 2.0d);
	}

	void check(int n, int x0, int y0, int xn2, int yn2, double ex, double ey) {
		in.input(n);
		in.input(x0 + " " + y0);
		in.input(xn2 + " " + yn2);
		execute();
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			double rx = scanner.nextDouble(), ry = scanner.nextDouble();
			assertTrue(Math.abs(rx - ex) < TOLERANCE, "rx is " + rx);
			assertTrue(Math.abs(ry - ey) < TOLERANCE, "ry is " + ry);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
	}
}
