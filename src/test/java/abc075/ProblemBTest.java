package abc075;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 5\n" + ".....\n" + ".#.#.\n" + ".....", "11211" + LF + "1#2#1" + LF + "11211");
	}

	@Test
	void case2() {
		check("3 5\n" + "#####\n" + "#####\n" + "#####", "#####" + LF + "#####" + LF + "#####");
	}

	@Test
	void case3() {
		check("6 6\n" + "#####.\n" + "#.#.##\n" + "####.#\n" + ".#..#.\n" + "#.##..\n" + "#.#...",
				"#####3" + LF + "#8#7##" + LF + "####5#" + LF + "4#65#2" + LF + "#5##21" + LF + "#4#310");
	}
}
