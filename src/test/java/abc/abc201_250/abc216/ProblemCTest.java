package abc.abc201_250.abc216;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Scanner;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check(5);
	}

	void check(long n) {
		in.input(n);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		long num = 0L;
		for (char c : lines[0].toCharArray()) {
			if ('A' == c) {
				num++;
			} else {
				num <<= 1;
			}
		}
		assertEquals(n, num);
	}

	@Test
	void case2() {
		check(14);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc216/C", (inputIs, expectedIs) -> {
			try (Scanner scanner = new Scanner(inputIs)) {
				long n = scanner.nextLong();
				check(n);
			}
		});
	}
}
