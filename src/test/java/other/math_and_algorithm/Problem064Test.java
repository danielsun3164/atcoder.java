package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem064Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "2 0 1", "Yes");
	}

	@Test
	void case2() {
		check("5 2\n" + "1 0 0 0 0", "No");
	}
}
