package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "4 10 6 3\n" + "6 5 4 3\n" + "1 1 0 0\n" + "31415 92653 58979 32384\n"
				+ "1000000000 1000000000 999999999 999999999",
				"3" + LF + "13" + LF + "0" + LF + "314095480" + LF + "499999999500000000");
	}
}
