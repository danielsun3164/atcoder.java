package abc007;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 9");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("40 49");
		ProblemD.main(null);
		assertResultIs("10");
	}

	@Test
	void test_Case3() {
		in.input("1 1000");
		ProblemD.main(null);
		assertResultIs("488");
	}

	@Test
	void test_Case4() {
		in.input("1 1000000000000000000");
		ProblemD.main(null);
		assertResultIs("981985601490518016");
	}
}
