package abc053;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "1 2 1 3 7");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("15\n" + "1 3 5 2 1 3 2 8 8 6 2 6 11 1 1");
		ProblemD.main(null);
		assertResultIs("7");
	}
}
