package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		checkResultIn("3 3\n" + "#..\n" + "..#\n" + "...", "3" + LF + "#><" + LF + "vv#" + LF + "^^.",
				"3" + LF + "#><" + LF + "v.#" + LF + "^><", "3" + LF + "#><" + LF + "><#" + LF + "><.");
	}

	@Test
	void case2() {
		checkResultIn(
				"10 10\n" + "#.........\n" + ".#........\n" + "..#.......\n" + "...#......\n" + "....#.....\n"
						+ ".....#....\n" + "......#...\n" + ".......#..\n" + "........#.\n" + ".........#",
				"40" + LF + "#.><v.><v." + LF + ".#><^v><^v" + LF + "v.#.v^v.v^" + LF + "^v.#^v^v^v" + LF + "v^><#^v^v^"
						+ LF + "^><><#^v^v" + LF + "><vvvv#^v^" + LF + "><^^^^.#^v" + LF + "vvvvv.><#^" + LF
						+ "^^^^^><><#",
				"40" + LF + "#><><><><v" + LF + "v#><><><v^" + LF + "^v#><><v^v" + LF + "v^v#><v^v^" + LF + "^v^v#.^v^v"
						+ LF + "v^v^v#.^v^" + LF + "^v^v^v#.^v" + LF + "v^v^v^v#.^" + LF + "^v^v^v^v#." + LF
						+ ".^.^.^.^.#");
	}
}
