package abc.abc104;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 700\n" + "3 500\n" + "5 800", "3");
	}

	@Test
	void case2() {
		check("2 2000\n" + "3 500\n" + "5 800", "7");
	}

	@Test
	void case3() {
		check("2 400\n" + "3 500\n" + "5 800", "2");
	}

	@Test
	void case4() {
		check("5 25000\n" + "20 1000\n" + "40 1000\n" + "50 1000\n" + "30 1000\n" + "1 1000", "66");
	}
}
