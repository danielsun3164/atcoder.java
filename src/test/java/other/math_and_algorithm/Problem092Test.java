package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem092Test extends TestBase {

	@Test
	void case1() {
		check("10", "14");
	}

	@Test
	void case2() {
		check("9", "12");
	}

	@Test
	void case3() {
		check("160", "52");
	}

	@Test
	void case4() {
		check("869120", "3732");
	}

	@Test
	void case5() {
		check("2147483647", "4294967296");
	}
}
