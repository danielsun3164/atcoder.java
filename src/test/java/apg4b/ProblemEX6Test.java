package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX6Test extends TestBase {

	@Test
	void case1() {
		check("1 + 2", "3");
	}

	@Test
	void case2() {
		check("5 - 3", "2");
	}

	@Test
	void case3() {
		check("10 * 20", "200");
	}

	@Test
	void case4() {
		check("10 / 3", "3");
	}

	@Test
	void case5() {
		check("100 / 0", "error");
	}

	@Test
	void case6() {
		check("25 ? 31", "error");
	}

	@Test
	void case7() {
		check("0 + 0", "0");
	}
}
