package other.atc001;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "s####\n" + "....#\n" + "#####\n" + "#...g", "No");
	}

	@Test
	void case2() {
		check("4 4\n" + "...s\n" + "....\n" + "....\n" + ".g..", "Yes");
	}

	@Test
	void case3() {
		check("10 10\n" + "s.........\n" + "#########.\n" + "#.......#.\n" + "#..####.#.\n" + "##....#.#.\n"
				+ "#####.#.#.\n" + "g.#.#.#.#.\n" + "#.#.#.#.#.\n" + "###.#.#.#.\n" + "#.....#...", "No");
	}

	@Test
	void case4() {
		check("10 10\n" + "s.........\n" + "#########.\n" + "#.......#.\n" + "#..####.#.\n" + "##....#.#.\n"
				+ "#####.#.#.\n" + "g.#.#.#.#.\n" + "#.#.#.#.#.\n" + "#.#.#.#.#.\n" + "#.....#...", "Yes");
	}

	@Test
	void case5() {
		check("1 10\n" + "s..####..g", "No");
	}
}
