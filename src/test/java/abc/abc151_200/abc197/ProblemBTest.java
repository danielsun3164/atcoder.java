package abc.abc151_200.abc197;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 4 2 2\n" + "##..\n" + "...#\n" + "#.#.\n" + ".#.#", "4");
	}

	@Test
	void case2() {
		check("3 5 1 4\n" + "#....\n" + "#####\n" + "....#", "4");
	}

	@Test
	void case3() {
		check("5 5 4 2\n" + ".#..#\n" + "#.###\n" + "##...\n" + "#..#.\n" + "#.###", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC197/B");
	}
}
