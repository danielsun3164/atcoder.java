package abc.abc101_150.abc135;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check(11, -1, 2, 3);
	}

	@Test
	void case2() {
		check("4600\n" + "52 149", "-1");
	}

	@Test
	void case3() {
		check(4, 9, 9, 5);
	}

	@Test
	void case4() {
		check(9943, -97653, -1777, 10);
	}

	@Test
	void case5() {
		check(411603622, -1675, 797, 2);
	}

	void check(int k, int x, int y, int m) {
		in.input(k);
		in.input(x + " " + y);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(m + 1, lines.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int s = scanner.nextInt();
			assertEquals(m, s);
			int preX = 0, preY = 0;
			for (int i = 1; i <= s; i++) {
				int xi = scanner.nextInt(), yi = scanner.nextInt();
				assertEquals(k, Math.abs(preX - xi) + Math.abs(preY - yi));
				if (s == i) {
					assertEquals(x, xi);
					assertEquals(y, yi);
				}
				preX = xi;
				preY = yi;
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC135/E", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int m = expectedScanner.nextInt();
				if (-1 == m) {
					check(inputIs, "-1");
					return;
				}
				check(inputScanner.nextInt(), inputScanner.nextInt(), inputScanner.nextInt(), m);
			}
		});
	}
}
