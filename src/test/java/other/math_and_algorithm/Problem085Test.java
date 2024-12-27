package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem085Test extends TestBase {

	@Test
	void case1() {
		check("6 11 30", "Yes");
	}

	@Test
	void case2() {
		check("1 1000000000 1", "No");
	}
}
