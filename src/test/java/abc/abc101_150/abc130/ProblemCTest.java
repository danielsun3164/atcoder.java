package abc.abc101_150.abc130;

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

	private void check(String input, double d, int n) {
		in.input(input);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\s+");
		assertEquals(2, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			assertNumberIsAbout(d, scanner.nextDouble(), TOLERANCE);
			assertEquals(n, scanner.nextInt());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC130/C", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				check(inputScanner.nextLine(), expectedScanner.nextDouble(), expectedScanner.nextInt());
			}
		});
	}
}
