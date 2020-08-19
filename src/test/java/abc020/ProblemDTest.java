package abc020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 2", "14");
	}

	@Test
	void case2() {
		check("10000 100", "865504986");
	}

	@Test
	void case3() {
		check("1000000000 90", "50001213");
	}

	@Test
	void case4() {
		check("1000000000 999999900", "231285006");
	}
}
