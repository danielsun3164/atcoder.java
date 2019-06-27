package abc028;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 2");
		ProblemD.main(null);
		assertResultIsAbout(0.48148148148148148148d, 0.000000001d);
	}

	@Test
	void test_Case2() {
		in.input("3 1");
		ProblemD.main(null);
		assertResultIsAbout(0.25925925925925925926d, 0.000000001d);
	}

	@Test
	void test_Case3() {
		in.input("765 573");
		ProblemD.main(null);
		assertResultIsAbout(0.00147697396984624371d, 0.000000001d);
	}
}
