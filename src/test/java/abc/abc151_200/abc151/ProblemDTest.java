package abc.abc151_200.abc151;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "...\n" + "...\n" + "...", "4");
	}

	@Test
	void case2() {
		check("3 5\n" + "...#.\n" + ".#.#.\n" + ".#...", "10");
	}
}
