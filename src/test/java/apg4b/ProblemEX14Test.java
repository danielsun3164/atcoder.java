package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX14Test extends TestBase {

	@Test
	void case1() {
		check("160 154 152", "8");
	}

	@Test
	void case2() {
		check("200 200 200", "0");
	}

	@Test
	void case3() {
		check("145 1 170", "169");
	}

	@Test
	void case4() {
		check("150 190 160", "40");
	}
}
