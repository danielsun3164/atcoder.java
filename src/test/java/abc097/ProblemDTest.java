package abc097;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5 2\n" + "5 3 1 4 2\n" + "1 3\n" + "5 4");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("3 2\n" + "3 2 1\n" + "1 2\n" + "2 3");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("10 8\n" + "5 3 6 8 7 10 9 1 2 4\n" + "3 1\n" + "4 1\n" + "5 9\n" + "2 5\n" + "6 5\n" + "3 5\n"
				+ "8 9\n" + "7 9");
		ProblemD.main(null);
		assertResultIs("8");
	}

	@Test
	void case4() {
		in.input("5 1\n" + "1 2 3 4 5\n" + "1 5");
		ProblemD.main(null);
		assertResultIs("5");
	}
}
