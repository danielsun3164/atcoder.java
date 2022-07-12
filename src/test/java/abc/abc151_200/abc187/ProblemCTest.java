package abc.abc151_200.abc187;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check(new String[] { "a", "!a", "b", "!c", "d", "!d" });
	}

	@Test
	void case2() {
		check("10\n" + "red\n" + "red\n" + "red\n" + "!orange\n" + "yellow\n" + "!blue\n" + "cyan\n" + "!green\n"
				+ "brown\n" + "!gray", "satisfiable");
	}

	void check(String[] s) {
		in.input(s.length);
		Arrays.stream(s).forEach(in::input);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		Set<String> set = Arrays.stream(s).collect(Collectors.toSet());
		assertTrue(set.contains(lines[0]) && set.contains("!" + lines[0]));
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC187/C", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			String result = expectedScanner.next();
			if ("satisfiable".equals(result)) {
				check(inputIs, result);
			} else {
				int n = inputScanner.nextInt();
				String[] s = IntStream.range(0, n).mapToObj(i -> inputScanner.next()).toArray(String[]::new);
				check(s);
			}
		}
	}
}
