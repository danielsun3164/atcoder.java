package abc102;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 4 6 3", "5");
	}

	@Test
	void case2() {
		check("2\n" + "1000000000 1", "999999999");
	}

	@Test
	void case3() {
		check("5\n" + "1 1 1 1 1", "0");
	}
}
