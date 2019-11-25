package abc016;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "1 2\n" + "2 3");
		ProblemC.main(null);
		assertResultIs("1" + LF + "0" + LF + "1");
	}

	@Test
	void case2() {
		in.input("3 3\n" + "1 2\n" + "1 3\n" + "2 3");
		ProblemC.main(null);
		assertResultIs("0" + LF + "0" + LF + "0");
	}

	@Test
	void case3() {
		in.input("8 12\n" + "1 6\n" + "1 7\n" + "1 8\n" + "2 5\n" + "2 6\n" + "3 5\n" + "3 6\n" + "4 5\n" + "4 8\n"
				+ "5 6\n" + "5 7\n" + "7 8");
		ProblemC.main(null);
		assertResultIs("4" + LF + "4" + LF + "4" + LF + "5" + LF + "2" + LF + "3" + LF + "4" + LF + "2");
	}
}
