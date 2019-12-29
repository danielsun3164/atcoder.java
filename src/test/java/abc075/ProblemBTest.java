package abc075;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 5\n" + ".....\n" + ".#.#.\n" + ".....");
		ProblemB.main(null);
		assertResultIs("11211" + LF + "1#2#1" + LF + "11211");
	}

	@Test
	void case2() {
		in.input("3 5\n" + "#####\n" + "#####\n" + "#####");
		ProblemB.main(null);
		assertResultIs("#####" + LF + "#####" + LF + "#####");
	}

	@Test
	void case3() {
		in.input("6 6\n" + "#####.\n" + "#.#.##\n" + "####.#\n" + ".#..#.\n" + "#.##..\n" + "#.#...");
		ProblemB.main(null);
		assertResultIs("#####3" + LF + "#8#7##" + LF + "####5#" + LF + "4#65#2" + LF + "#5##21" + LF + "#4#310");
	}
}
