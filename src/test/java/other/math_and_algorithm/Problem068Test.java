package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem068Test extends TestBase {

	@Test
	void case1() {
		check("100 3\n" + "2 3 5", "74");
	}

	@Test
	void case2() {
		check("100 3\n" + "2 4 6", "50");
	}

	@Test
	void case3() {
		check("10000000000000 10\n" + "13 17 19 23 29 31 37 41 43 47", "3324865541894");
	}
}
