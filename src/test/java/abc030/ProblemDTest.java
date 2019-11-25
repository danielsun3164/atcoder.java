package abc030;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("6 4\n" + "5\n" + "2 3 1 2 6 5");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("4 1\n" + "100000000000000000000\n" + "2 3 4 1");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("8 1\n" + "1\n" + "2 3 4 5 3 2 4 5");
		ProblemD.main(null);
		assertResultIs("2");
	}
}
