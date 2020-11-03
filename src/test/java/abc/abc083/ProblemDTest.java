package abc.abc083;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("010", "2");
	}

	@Test
	void case2() {
		check("100000000", "8");
	}

	@Test
	void case3() {
		check("00001111", "4");
	}

	@Test
	void case4() {
		check("00000", "5");
	}

	@Test
	void case5() {
		check("111111", "6");
	}
}
