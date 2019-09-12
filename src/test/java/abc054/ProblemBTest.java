package abc054;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 2\n" + "#.#\n" + ".#.\n" + "#.#\n" + "#.\n" + ".#");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case2() {
		in.input("4 1\n" + "....\n" + "....\n" + "....\n" + "....\n" + "#");
		ProblemB.main(null);
		assertResultIs("No");
	}
}
