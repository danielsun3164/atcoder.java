package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem097Test extends TestBase {

	@Test
	void case1() {
		check("21 40", "4");
	}

	@Test
	void case2() {
		check("101 130", "6");
	}

	@Test
	void case3() {
		check("1 100", "25");
	}

	@Test
	void case4() {
		check("217 217", "0");
	}

	@Test
	void case5() {
		check("999999500000 1000000000000", "18228");
	}
}
