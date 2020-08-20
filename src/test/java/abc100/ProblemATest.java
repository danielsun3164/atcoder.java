package abc100;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 4", "Yay!");
	}

	@Test
	void case2() {
		check("8 8", "Yay!");
	}

	@Test
	void case3() {
		check("11 4", ":(");
	}
}
