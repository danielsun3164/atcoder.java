package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX17Test extends TestBase {

	@Test
	void case1() {
		check("3 400\n" + "100 100 130\n" + "270 300 250", "3");
	}

	@Test
	void case2() {
		check("10 600\n" + "70 110 90 120 90 20 260 150 220 150\n" + "170 100 250 350 60 280 450 460 20 220", "2");
	}

	@Test
	void case3() {
		check("3 200\n" + "100 100 100\n" + "100 100 100", "9");
	}

	@Test
	void case4() {
		check("1 0\n" + "100\n" + "200", "0");
	}
}
