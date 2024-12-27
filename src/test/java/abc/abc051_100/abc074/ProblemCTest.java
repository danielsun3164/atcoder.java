package abc.abc051_100.abc074;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 2 10 20 15 200", "110 10");
	}

	void check(int a, int b, int c, int d, int e, int f, int ex, int ey) {
		in.input(a + " " + b + " " + c + " " + d + " " + e + " " + f);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\s+");
		assertEquals(2, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int x = scanner.nextInt(), y = scanner.nextInt();
			assertTrue(x <= f, x + " is larger than " + f);
			int z = x - y;
			// z = n*100a+m*100b
			boolean foundZ = false;
			for (int i = 0; i <= z / 100 / a; i++) {
				if (0 == (z - i * 100 * a) % (100 * b)) {
					foundZ = true;
					break;
				}
			}
			assertTrue(foundZ, z + " is not combination of " + (100 * a) + " and " + (100 * b));
			// y = n*c+m*d
			boolean foundY = false;
			for (int i = 0; i <= y / c; i++) {
				if (0 == (y - i * c) % d) {
					foundY = true;
					break;
				}
			}
			assertTrue(foundY, y + " is not combination of " + c + " and " + d);
			assertTrue(ex * y == x * ey, x + "," + y + " is not the same proportion of " + ex + "," + ey);
		} catch (IOException e1) {
			e1.printStackTrace();
			fail(e1);
		}
	}

	@Test
	void case2() {
		check("1 2 1 2 100 1000", "800 400");
	}

	@Test
	void case3() {
		check("17 19 22 26 55 2802", "2634 934");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC083/C", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				check(inputScanner.nextInt(), inputScanner.nextInt(), inputScanner.nextInt(), inputScanner.nextInt(),
						inputScanner.nextInt(), inputScanner.nextInt(), expectedScanner.nextInt(),
						expectedScanner.nextInt());
			}
		});
	}
}
