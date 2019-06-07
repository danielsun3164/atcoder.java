package abc016;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 0 1");
		ProblemB.main(null);
		assertResultIs("?");
	}

	@Test
	void test_Case2() {
		in.input("1 1 2");
		ProblemB.main(null);
		assertResultIs("+");
	}

	@Test
	void test_Case3() {
		in.input("1 1 0");
		ProblemB.main(null);
		assertResultIs("-");
	}

	@Test
	void test_Case4() {
		in.input("1 1 1");
		ProblemB.main(null);
		assertResultIs("!");
	}
}
