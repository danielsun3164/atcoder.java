package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemC別回答Test extends TestBase {

	@Test
	void case1() {
		check("5 3 2\n" + "1 5 1 5", "...#." + LF + "#.#.." + LF + ".#..." + LF + "#.#.." + LF + "...#.");
	}

	@Test
	void case2() {
		check("5 3 3\n" + "4 5 2 5", "#.#." + LF + "...#");
	}

	@Test
	void case3() {
		check("1000000000000000000 999999999999999999 999999999999999999\n"
				+ "999999999999999998 1000000000000000000 999999999999999998 1000000000000000000",
				"#.#" + LF + ".#." + LF + "#.#");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/C");
	}
}
