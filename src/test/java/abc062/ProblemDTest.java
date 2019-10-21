package abc062;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2\n" + "3 1 4 1 5 9");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("1\n" + "1 2 3");
		ProblemD.main(null);
		assertResultIs("-1");
	}

	@Test
	void test_Case3() {
		in.input("3\n" + "8 2 2 7 4 6 5 3 8");
		ProblemD.main(null);
		assertResultIs("5");
	}
}
