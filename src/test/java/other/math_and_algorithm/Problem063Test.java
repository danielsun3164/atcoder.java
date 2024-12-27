package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem063Test extends TestBase {

	@Test
	void case1() {
		check("2", "Yes");
	}

	@Test
	void case2() {
		check("3", "No");
	}
}
