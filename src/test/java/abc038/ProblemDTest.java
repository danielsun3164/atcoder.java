package abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "3 3\n" + "1 1\n" + "2 2");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("2\n" + "4 5\n" + "4 3");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("4\n" + "2 5\n" + "3 3\n" + "4 5\n" + "6 6");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case4() {
		in.input("5\n" + "8 8\n" + "5 3\n" + "2 2\n" + "4 2\n" + "2 1");
		ProblemD.main(null);
		assertResultIs("4");
	}
}
