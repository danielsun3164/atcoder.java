package abc011;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("2 10000000\n" + "10000000 10000000");
		ProblemD.main(null);
		assertResultIs(0.125d);
	}

	@Test
	void case2() {
		in.input("100 2\n" + "3 7");
		ProblemD.main(null);
		assertResultIs(0.0d);
	}

	@Test
	void case3() {
		in.input("11 8562174\n" + "25686522 17124348");
		ProblemD.main(null);
		assertResultIsAbout(0.018174648284912d, 0.000000001d);
	}
}
