package abc096;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 3\n" + ".#.\n" + "###\n" + ".#.");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("5 5\n" + "#.#.#\n" + ".#.#.\n" + "#.#.#\n" + ".#.#.\n" + "#.#.#");
		ProblemC.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("11 11\n" + "...#####...\n" + ".##.....##.\n" + "#..##.##..#\n" + "#..##.##..#\n" + "#.........#\n"
				+ "#...###...#\n" + ".#########.\n" + ".#.#.#.#.#.\n" + "##.#.#.#.##\n" + "..##.#.##..\n"
				+ ".##..#..##.");
		ProblemC.main(null);
		assertResultIs("Yes");
	}
}
