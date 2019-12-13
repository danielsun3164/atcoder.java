package abc074;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "0 1 3\n" + "1 0 2\n" + "3 2 0");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("3\n" + "0 1 3\n" + "1 0 1\n" + "3 1 0");
		ProblemD.main(null);
		assertResultIs("-1");
	}

	@Test
	void case3() {
		in.input("5\n" + "0 21 18 11 28\n" + "21 0 13 10 26\n" + "18 13 0 23 13\n" + "11 10 23 0 17\n"
				+ "28 26 13 17 0");
		ProblemD.main(null);
		assertResultIs("82");
	}

	@Test
	void case4() {
		in.input("3\n" + "0 1000000000 1000000000\n" + "1000000000 0 1000000000\n" + "1000000000 1000000000 0");
		ProblemD.main(null);
		assertResultIs("3000000000");
	}
}
