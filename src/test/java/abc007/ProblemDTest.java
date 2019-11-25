package abc007;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("1 9");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("40 49");
		ProblemD.main(null);
		assertResultIs("10");
	}

	@Test
	void case3() {
		in.input("1 1000");
		ProblemD.main(null);
		assertResultIs("488");
	}

	@Test
	void case4() {
		in.input("1 1000000000000000000");
		ProblemD.main(null);
		assertResultIs("981985601490518016");
	}
}
