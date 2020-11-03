package abc.abc054;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "#.#\n" + ".#.\n" + "#.#\n" + "#.\n" + ".#", "Yes");
	}

	@Test
	void case2() {
		check("4 1\n" + "....\n" + "....\n" + "....\n" + "....\n" + "#", "No");
	}
}
