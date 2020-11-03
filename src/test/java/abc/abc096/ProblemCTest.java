package abc.abc096;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + ".#.\n" + "###\n" + ".#.", "Yes");
	}

	@Test
	void case2() {
		check("5 5\n" + "#.#.#\n" + ".#.#.\n" + "#.#.#\n" + ".#.#.\n" + "#.#.#", "No");
	}

	@Test
	void case3() {
		check("11 11\n" + "...#####...\n" + ".##.....##.\n" + "#..##.##..#\n" + "#..##.##..#\n" + "#.........#\n"
				+ "#...###...#\n" + ".#########.\n" + ".#.#.#.#.#.\n" + "##.#.#.#.##\n" + "..##.#.##..\n"
				+ ".##..#..##.", "Yes");
	}
}
