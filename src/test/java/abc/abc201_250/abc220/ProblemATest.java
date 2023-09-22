package abc.abc201_250.abc220;

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

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check(123, 456, 100);
	}

	private void check(int a, int b, int c) {
		in.input(a + " " + b + " " + c);
		execute();
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			int result = scanner.nextInt();
			assertTrue(result >= a, "result is " + result);
			assertTrue(result <= b, "result is " + result);
			assertEquals(0, result % c, "result is " + result);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	void case2() {
		check("630 940 314", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/A", (inputIs, expectedIs) -> {
			try (Scanner expectedScanner = new Scanner(expectedIs)) {
				int result = expectedScanner.nextInt();
				if (-1 == result) {
					check(inputIs, "-1");
				} else {
					try (Scanner inputScanner = new Scanner(inputIs)) {
						int a = inputScanner.nextInt(), b = inputScanner.nextInt(), c = inputScanner.nextInt();
						check(a, b, c);
					}
				}
			}
		});
	}
}
