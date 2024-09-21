package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem002Test extends TestBase {

	@Test
	void case1() {
		check("10 20 50", "80");
	}

	@Test
	void case2() {
		check("1 1 1", "3");
	}

	@Test
	void case3() {
		check("100 100 100", "300");
	}
}
