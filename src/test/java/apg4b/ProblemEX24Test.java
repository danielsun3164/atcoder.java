package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX24Test extends TestBase {

	@Test
	void case1() {
		check("0 0 0\n" + "90", "00:00:00" + LF + "00:01:30");
	}

	@Test
	void case2() {
		check("0 0 0\n" + "-5", "00:00:00" + LF + "23:59:55");
	}

	@Test
	void case3() {
		check("23 59 30\n" + "30", "23:59:30" + LF + "00:00:00");
	}

	@Test
	void case4() {
		check("6 57 9\n" + "-4195", "06:57:09" + LF + "05:47:14");
	}
}
