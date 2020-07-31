package abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("24");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("1");
		ProblemD.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("64");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case4() {
		in.input("1000000007");
		ProblemD.main(null);
		assertResultIs("1");
	}
}
