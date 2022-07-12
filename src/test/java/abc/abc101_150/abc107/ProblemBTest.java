package abc.abc101_150.abc107;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "##.#\n" + "....\n" + "##.#\n" + ".#.#", "###" + LF + "###" + LF + ".##");
	}

	@Test
	void case2() {
		check("3 3\n" + "#..\n" + ".#.\n" + "..#", "#.." + LF + ".#." + LF + "..#");
	}

	@Test
	void case3() {
		check("4 5\n" + ".....\n" + ".....\n" + "..#..\n" + ".....", "#");
	}

	@Test
	void case4() {
		check("7 6\n" + "......\n" + "....#.\n" + ".#....\n" + "..#...\n" + "..#...\n" + "......\n" + ".#..#.",
				"..#" + LF + "#.." + LF + ".#." + LF + ".#." + LF + "#.#");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC107/B");
	}
}
