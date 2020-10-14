package other.hhkb2020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 1 0 2", "0" + LF + "0" + LF + "2" + LF + "3");
	}

	@Test
	void case2() {
		check("10\n" + "5 4 3 2 1 0 7 7 6 6",
				"0" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF + "6" + LF + "6" + LF + "6" + LF + "8" + LF + "8");
	}
}
