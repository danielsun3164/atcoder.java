package abc054;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "#.#\n" + ".#.\n" + "#.#\n" + "#.\n" + ".#");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("4 1\n" + "....\n" + "....\n" + "....\n" + "....\n" + "#");
		ProblemB.main(null);
		assertResultIs("No");
	}
}
