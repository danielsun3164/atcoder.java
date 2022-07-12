package abc.abc151_200.abc166;

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

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(33);
	}

	@Test
	void case2() {
		check(1);
	}

	private void check(int x) {
		in.input(x);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		String[] numbers = lines[0].split("\\ ");
		assertEquals(2, numbers.length);
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			long a = scanner.nextLong(), b = scanner.nextLong();
			assertEquals(x, a * a * a * a * a - b * b * b * b * b);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC166/D", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner scanner = new Scanner(inputIs)) {
			check(scanner.nextInt());
		}
	}
}
