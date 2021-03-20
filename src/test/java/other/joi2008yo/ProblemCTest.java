package other.joi2008yo;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1\n" + "7\n" + "9\n" + "6\n" + "10", "3" + LF + "0");
	}

	@Test
	void case2() {
		check("10\n" + "8\n" + "7\n" + "14\n" + "18\n" + "4\n" + "11\n" + "3\n" + "17\n" + "5\n" + "19",
				"2" + LF + "0");
	}
}
