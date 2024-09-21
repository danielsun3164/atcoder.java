package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem054Test extends TestBase {

	@Test
	void case1() {
		check("10", "55");
	}

	@Test
	void case2() {
		check("876543210987654321", "942619746");
	}
}
