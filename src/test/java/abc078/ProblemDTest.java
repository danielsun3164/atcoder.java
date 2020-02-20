package abc078;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 100 100\n" + "10 1000 100");
		ProblemD.main(null);
		assertResultIs("900");
	}

	@Test
	void case2() {
		in.input("3 100 1000\n" + "10 100 100");
		ProblemD.main(null);
		assertResultIs("900");
	}

	@Test
	void case3() {
		in.input("5 1 1\n" + "1 1 1 1 1");
		ProblemD.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("1 1 1\n" + "1000000000");
		ProblemD.main(null);
		assertResultIs("999999999");
	}
}
