package abc.abc078;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("13 3 1", "3");
	}

	@Test
	void case2() {
		check("12 3 1", "2");
	}

	@Test
	void case3() {
		check("100000 1 1", "49999");
	}

	@Test
	void case4() {
		check("64146 123 456", "110");
	}

	@Test
	void case5() {
		check("64145 123 456", "109");
	}
}
