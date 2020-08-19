package abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3", "2");
	}

	@Test
	void case2() {
		check("5\n" + "2 0 0 0 3", "3");
	}

	@Test
	void case3() {
		check("2\n" + "0 99", "-1");
	}

	@Test
	void case4() {
		check("4\n" + "0 0 0 0", "0");
	}
}
