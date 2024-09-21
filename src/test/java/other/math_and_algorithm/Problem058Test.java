package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem058Test extends TestBase {

	@Test
	void case1() {
		check("10 2 2", "Yes");
	}

	@Test
	void case2() {
		check("9 3 1", "No");
	}
}
