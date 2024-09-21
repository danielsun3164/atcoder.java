package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem080Test extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 2 3\n" + "1 3 4\n" + "3 4 1\n" + "2 4 10", "5");
	}

	@Test
	void case2() {
		check("2 0", "-1");
	}
}
