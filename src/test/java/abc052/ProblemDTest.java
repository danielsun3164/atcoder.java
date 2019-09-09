package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4 2 5\n" + "1 2 5 7");
		ProblemD.main(null);
		assertResultIs("11");
	}

	@Test
	void test_Case2() {
		in.input("7 1 100\n" + "40 43 45 105 108 115 124");
		ProblemD.main(null);
		assertResultIs("84");
	}

	@Test
	void test_Case3() {
		in.input("7 1 2\n" + "24 35 40 68 72 99 103");
		ProblemD.main(null);
		assertResultIs("12");
	}
}
