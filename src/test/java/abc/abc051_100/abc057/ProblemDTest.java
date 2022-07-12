package abc.abc051_100.abc057;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	/** 誤差 */
	private static final double TOLERANCE = 1E-6d;

	@Test
	void case1() {
		check("5 2 2\n" + "1 2 3 4 5", 4.5d, "1");
	}

	private void check(String input, double average, String n) {
		in.input(input);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(2, lines.length);
		assertNumberIsAbout(average, lines[0], TOLERANCE);
		assertEquals(n, lines[1]);
	}

	@Test
	void case2() {
		check("4 2 3\n" + "10 20 10 10", 15.0d, "3");
	}

	@Test
	void case3() {
		check("5 1 5\n" + "1000000000000000 999999999999999 999999999999998 999999999999997 999999999999996",
				1000000000000000.0d, "1");
	}

	@Test
	void case4() {
		check("50 1 50\n"
				+ "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1",
				1.0d, "1125899906842623");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC057/D", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (ByteArrayOutputStream boas = new ByteArrayOutputStream(); Scanner scanner = new Scanner(expectedIs)) {
			byte[] buffer = new byte[8192];
			int length = 0;
			while (-1 != (length = inputIs.read(buffer))) {
				boas.write(buffer, 0, length);
			}
			check(boas.toString(), scanner.nextDouble(), scanner.next());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
