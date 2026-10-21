package abc.abc201_250.abc246;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		check(3, 4, new double[] { 0.600000000000d, 0.800000000000d });
	}

	@Test
	void case2() {
		check(1, 0, new double[] { 1.000000000000d, 0.000000000000d });
	}

	@Test
	void case3() {
		check(246, 402, new double[] { 0.521964870245d, 0.852966983083d });
	}

	void check(int a, int b, double[] expected) {
		in.input(a + " " + b);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\s+");
		assertEquals(2, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			IntStream.range(0, 2).forEach(i -> assertNumberIsAbout(expected[i], scanner.nextDouble(), TOLERANCE));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/B", (inputIs, expectedIs) -> {
			try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
				int a = inputScanner.nextInt(), b = inputScanner.nextInt();
				double expected1 = expectedScanner.nextDouble(), expected2 = expectedScanner.nextDouble();
				check(a, b, new double[] { expected1, expected2 });
			}
		});
	}
}
