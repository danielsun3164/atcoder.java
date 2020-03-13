package abc085;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("1 10\n" + "3 5");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("2 10\n" + "3 5\n" + "2 6");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("4 1000000000\n" + "1 1\n" + "1 10000000\n" + "1 30000000\n" + "1 99999999");
		ProblemD.main(null);
		assertResultIs("860000004");
	}

	@Test
	void case4() {
		in.input("5 500\n" + "35 44\n" + "28 83\n" + "46 62\n" + "31 79\n" + "40 43");
		ProblemD.main(null);
		assertResultIs("9");
	}
}
