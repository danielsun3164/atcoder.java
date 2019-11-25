package abc014;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "1 2\n" + "1 3\n" + "1 4\n" + "4 5\n" + "3\n" + "2 3\n" + "2 5\n" + "2 4");
		ProblemD.main(null);
		assertResultIs("3" + LF + "4" + LF + "3");
	}

	@Test
	void case2() {
		in.input("6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 6\n" + "4\n" + "1 3\n" + "1 4\n" + "1 5\n" + "1 6");
		ProblemD.main(null);
		assertResultIs("3" + LF + "4" + LF + "5" + LF + "6");
	}

	@Test
	void case3() {
		in.input("7\n" + "3 1\n" + "2 1\n" + "2 4\n" + "2 5\n" + "3 6\n" + "3 7\n" + "5\n" + "4 5\n" + "1 6\n" + "5 6\n"
				+ "4 7\n" + "5 3");
		ProblemD.main(null);
		assertResultIs("3" + LF + "3" + LF + "5" + LF + "5" + LF + "4");
	}
}
