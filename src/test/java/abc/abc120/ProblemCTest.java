package abc.abc120;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("0011", "4");
	}

	@Test
	void case2() {
		check("11011010001011", "12");
	}

	@Test
	void case3() {
		check("0", "0");
	}
}
