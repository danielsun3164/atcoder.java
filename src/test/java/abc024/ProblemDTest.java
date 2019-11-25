package abc024;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("15\n" + "35\n" + "21");
		ProblemD.main(null);
		assertResultIs("4 2");
	}

	@Test
	void case2() {
		in.input("126\n" + "252\n" + "210");
		ProblemD.main(null);
		assertResultIs("5 4");
	}

	@Test
	void case3() {
		in.input("144949225\n" + "545897619\n" + "393065978");
		ProblemD.main(null);
		assertResultIs("314159 365358");
	}
}
