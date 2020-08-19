package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX18Test extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2\n" + "3 1", "- o x" + LF + "x - -" + LF + "o - -");
	}

	@Test
	void case2() {
		check("7 12\n" + "1 5\n" + "5 4\n" + "6 2\n" + "1 7\n" + "2 4\n" + "6 3\n" + "1 3\n" + "6 4\n" + "3 7\n"
				+ "5 7\n" + "4 3\n" + "6 1",
				"- - o - o x o" + LF + "- - - o - x -" + LF + "x - - x - x o" + LF + "- x o - x x -" + LF
						+ "x - - o - - o" + LF + "o o o o - - -" + LF + "x - x - x - -");
	}

	@Test
	void case3() {
		check("1 0", "-");
	}
}
