package abc107;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "-30 -10 10 20 50", "40");
	}

	@Test
	void case2() {
		check("3 2\n" + "10 20 30", "20");
	}

	@Test
	void case3() {
		check("1 1\n" + "0", "0");
	}

	@Test
	void case4() {
		check("8 5\n" + "-9 -7 -4 -3 1 2 3 4", "10");
	}
}
