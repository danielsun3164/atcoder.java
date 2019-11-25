package abc065;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "1 5\n" + "3 9\n" + "7 8");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("6\n" + "8 3\n" + "4 9\n" + "12 19\n" + "18 1\n" + "13 5\n" + "7 6");
		ProblemD.main(null);
		assertResultIs("8");
	}

	@Test
	void case3() {
		in.input("7\n" + "8 3\n" + "4 9\n" + "4 9\n" + "12 19\n" + "18 1\n" + "13 5\n" + "7 6");
		ProblemD.main(null);
		assertResultIs("8");
	}
}
