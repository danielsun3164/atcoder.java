package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX23Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 4 4 2 3", "4 2");
	}

	@Test
	void case2() {
		check("6\n" + "3 2 3 1 3 2", "3 3");
	}

	@Test
	void case3() {
		check("1\n" + "1000000000", "1000000000 1");
	}
}
