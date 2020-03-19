package abc090;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5 2");
		ProblemD.main(null);
		assertResultIs("7");
	}

	@Test
	void case2() {
		in.input("10 0");
		ProblemD.main(null);
		assertResultIs("100");
	}

	@Test
	void case3() {
		in.input("31415 9265");
		ProblemD.main(null);
		assertResultIs("287927211");
	}
}
