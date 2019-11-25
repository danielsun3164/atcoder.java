package abc002;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5 3\n" + "1 2\n" + "2 3\n" + "1 3");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("5 3\n" + "1 2\n" + "2 3\n" + "3 4");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("7 9\n" + "1 2\n" + "1 3\n" + "2 3\n" + "4 5\n" + "4 6\n" + "4 7\n" + "5 6\n" + "5 7\n" + "6 7");
		ProblemD.main(null);
		assertResultIs("4");
	}

	@Test
	void case4() {
		in.input("12 0");
		ProblemD.main(null);
		assertResultIs("1");
	}
}
