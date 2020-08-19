package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX13Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 1 4", "0" + LF + "1" + LF + "2");
	}

	@Test
	void case2() {
		check("2\n" + "80 70", "5" + LF + "5");
	}

	@Test
	void case3() {
		check("5\n" + "100 100 100 100 100", "0" + LF + "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@Test
	void case4() {
		check("10\n" + "53 21 99 83 75 40 33 62 18 100", "5" + LF + "37" + LF + "41" + LF + "25" + LF + "17" + LF + "18"
				+ LF + "25" + LF + "4" + LF + "40" + LF + "42");
	}
}
