package abc003;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 2\n" + "2 2\n" + "2 2\n" + "3 2\n" + "2 2\n" + "2 2");
		ProblemD.main(null);
		assertResultIs("12");
	}

	@Test
	void test_Case2() {
		in.input("4 5\n" + "3 1\n" + "3 0");
		ProblemD.main(null);
		assertResultIs("10");
	}

	@Test
	void test_Case3() {
		in.input("23 18\n" + "15 13\n" + "100 95");
		ProblemD.main(null);
		assertResultIs("364527243");
	}

	@Test
	void test_Case4() {
		in.input("30 30\n" + "24 22\n" + "145 132");
		ProblemD.main(null);
		assertResultIs("976668549");
	}
}
