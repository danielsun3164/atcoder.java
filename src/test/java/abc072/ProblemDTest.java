package abc072;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "1 4 3 5 2");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("2\n" + "1 2");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("2\n" + "2 1");
		ProblemD.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("9\n" + "1 2 4 9 5 8 7 3 6");
		ProblemD.main(null);
		assertResultIs("3");
	}
}
