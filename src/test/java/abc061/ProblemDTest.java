package abc061;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 3\n" + "1 2 4\n" + "2 3 3\n" + "1 3 5");
		ProblemD.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case2() {
		in.input("2 2\n" + "1 2 1\n" + "2 1 1");
		ProblemD.main(null);
		assertResultIs("inf");
	}

	@Test
	void test_Case3() {
		in.input("6 5\n" + "1 2 -1000000000\n" + "2 3 -1000000000\n" + "3 4 -1000000000\n" + "4 5 -1000000000\n"
				+ "5 6 -1000000000");
		ProblemD.main(null);
		assertResultIs("-5000000000");
	}
}
