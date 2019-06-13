package abc022;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "0 0\n" + "0 1\n" + "1 0\n" + "1 1\n" + "0 2\n" + "2 0\n" + "-2 0\n" + "0 -2");
		ProblemD.main(null);
		assertResultIsAbout(2.8284271247d, 0.0000001d);
	}

	@Test
	void test_Case2() {
		in.input("6\n" + "3 4\n" + "1 3\n" + "4 3\n" + "2 2\n" + "0 1\n" + "2 0\n" + "5 5\n" + "-1 2\n" + "-1 -3\n"
				+ "2 1\n" + "2 6\n" + "4 -3");
		ProblemD.main(null);
		assertResultIsAbout(2.2360679775d, 0.0000001d);
	}
}
