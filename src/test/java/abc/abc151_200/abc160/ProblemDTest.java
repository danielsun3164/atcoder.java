package abc.abc151_200.abc160;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2 4", "5" + LF + "4" + LF + "1" + LF + "0");
	}

	@Test
	void case2() {
		check("3 1 3", "3" + LF + "0");
	}

	@Test
	void case3() {
		check("7 3 7", "7" + LF + "8" + LF + "4" + LF + "2" + LF + "0" + LF + "0");
	}

	@Test
	void case4() {
		check("10 4 8", "10" + LF + "12" + LF + "10" + LF + "8" + LF + "4" + LF + "1" + LF + "0" + LF + "0" + LF + "0");
	}
}
