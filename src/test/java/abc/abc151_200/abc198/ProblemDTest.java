package abc.abc151_200.abc198;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check(new String[] { "a", "b", "c" });
	}

	@Test
	void case2() {
		check(new String[] { "x", "x", "y" });
	}

	@Test
	void case3() {
		check("p\n" + "q\n" + "p", "UNSOLVABLE");
	}

	@Test
	void case4() {
		check("abcd\n" + "efgh\n" + "ijkl", "UNSOLVABLE");
	}

	@Test
	void case5() {
		check(new String[] { "send", "more", "money" });
	}

	void check(String[] s) {
		Arrays.stream(s).forEach(si -> in.input(si));
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(s.length, lines.length);
		Map<Character, Character> map = new HashMap<>();
		IntStream.range(0, lines.length).forEach(i -> {
			assertEquals(s[i].length(), lines[i].length());
			IntStream.range(0, s[i].length()).forEach(j -> {
				if (map.containsKey(s[i].charAt(j))) {
					assertEquals(map.get(s[i].charAt(j)), lines[i].charAt(j));
				} else {
					map.put(s[i].charAt(j), lines[i].charAt(j));
				}
			});
		});
		long n1 = Long.parseLong(lines[0]), n2 = Long.parseLong(lines[1]), n3 = Long.parseLong(lines[2]);
		assertEquals(n3, n1 + n2);
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc198/D", this::check);
	}

	void check(InputStream inputIs, InputStream expectedIs) {
		try (Scanner inputScanner = new Scanner(inputIs); Scanner expectedScanner = new Scanner(expectedIs)) {
			String result = expectedScanner.next();
			if ("UNSOLVABLE".equals(result)) {
				check(inputIs, result);
			} else {
				String[] s = IntStream.range(0, 3).mapToObj(i -> inputScanner.next()).toArray(String[]::new);
				check(s);
			}
		}
	}
}
