package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem050Test extends TestBase {

	@Test
	void case1() {
		check("5 23", "871631629");
	}

	@Test
	void case2() {
		check("97 998244353", "934801994");
	}
}
