package abc.abc174;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "WWRR", "2");
	}

	@Test
	void case2() {
		check("2\n" + "RR", "0");
	}

	@Test
	void case3() {
		check("8\n" + "WRWWRWRR", "3");
	}
}
