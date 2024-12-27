package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem007Test extends TestBase {

	@Test
	void case1() {
		check("15 3 5", "7");
	}

	@Test
	void case2() {
		check("1000000 11 13", "160839");
	}
}
