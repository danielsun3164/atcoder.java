package abc080;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "1 7 2\n" + "7 8 1\n" + "8 12 1");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("3 4\n" + "1 3 2\n" + "3 4 4\n" + "1 4 3");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("9 4\n" + "56 60 4\n" + "33 37 2\n" + "89 90 3\n" + "32 43 1\n" + "67 68 3\n" + "49 51 3\n"
				+ "31 32 3\n" + "70 71 1\n" + "11 12 3");
		ProblemD.main(null);
		assertResultIs("2");
	}
}
