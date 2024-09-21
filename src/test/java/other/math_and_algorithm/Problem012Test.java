package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem012Test extends TestBase {

	@Test
	void case1() {
		check("53", "Yes");
	}

	@Test
	void case2() {
		check("77", "No");
	}

	@Test
	void case3() {
		check("472249589291", "Yes");
	}
}
