package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "1 3\n" + "2 2\n" + "3 2\n" + "4 1\n" + "4 3");
		ProblemD.main(null);
		assertResultIs("1 2 7");
	}

	@Test
	void test_Case2() {
		in.input("9\n" + "2 0\n" + "1 1\n" + "3 1\n" + "1 2\n" + "5 2\n" + "0 3\n" + "4 3\n" + "2 4\n" + "4 4");
		ProblemD.main(null);
		assertResultIs("27 14 43");
	}
}
