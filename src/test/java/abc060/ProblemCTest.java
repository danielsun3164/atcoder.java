package abc060;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 4\n" + "0 3", "7");
	}

	@Test
	void case2() {
		check("2 4\n" + "0 5", "8");
	}

	@Test
	void case3() {
		check("4 1000000000\n" + "0 1000 1000000 1000000000", "2000000000");
	}

	@Test
	void case4() {
		check("1 1\n" + "0", "1");
	}

	@Test
	void case5() {
		check("9 10\n" + "0 3 5 7 100 110 200 300 311", "67");
	}
}
