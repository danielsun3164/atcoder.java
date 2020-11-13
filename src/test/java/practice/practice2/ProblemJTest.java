package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemJTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "1 2 3 2 1\n" + "2 1 5\n" + "3 2 3\n" + "1 3 1\n" + "2 2 4\n" + "3 1 3",
				"3" + LF + "3" + LF + "2" + LF + "6");
	}

	@Test
	void case2() {
		check("1 5\n" + "1\n" + "2 1 1\n" + "3 1 3\n" + "1 1 4\n" + "2 1 1\n" + "3 1 3",
				"1" + LF + "2" + LF + "4" + LF + "1");
	}
}
