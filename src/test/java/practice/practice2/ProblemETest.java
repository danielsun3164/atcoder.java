package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "5 3 2\n" + "1 4 8\n" + "7 6 9", "19" + LF + "X.." + LF + "..X" + LF + ".X.");
	}

	@Test
	void case2() {
		check("3 2\n" + "10 10 1\n" + "10 10 1\n" + "1 1 10", "50" + LF + "XX." + LF + "XX." + LF + "..X");
	}
}
