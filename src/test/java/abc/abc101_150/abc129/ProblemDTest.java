package abc.abc101_150.abc129;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 6\n" + "#..#..\n" + ".....#\n" + "....#.\n" + "#.#...", "8");
	}

	@Test
	void case2() {
		check("8 8\n" + "..#...#.\n" + "....#...\n" + "##......\n" + "..###..#\n" + "...#..#.\n" + "##....#.\n"
				+ "#...#...\n" + "###.#..#", "13");
	}
}
