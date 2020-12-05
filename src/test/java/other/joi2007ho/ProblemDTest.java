package other.joi2007ho;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "5\n" + "1 2\n" + "3 1\n" + "3 2\n" + "3 4\n" + "4 1",
				"3" + LF + "4" + LF + "1" + LF + "2" + LF + "0");
	}

	@Test
	void case2() {
		checkResultIn("3\n" + "2\n" + "2 1\n" + "2 3", "2" + LF + "1" + LF + "3" + LF + "1",
				"2" + LF + "3" + LF + "1" + LF + "1");
	}
}
