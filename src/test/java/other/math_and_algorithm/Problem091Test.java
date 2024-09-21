package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem091Test extends TestBase {

	@Test
	void case1() {
		check("5 9", "2");
	}

	@Test
	void case2() {
		check("8 16", "5");
	}

	@Test
	void case3() {
		check("3 20", "0");
	}

	@Test
	void case4() {
		check("29 47", "97");
	}

	@Test
	void case5() {
		check("100 160", "1213");
	}
}
