package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem035Test extends TestBase {

	@Test
	void case1() {
		check("4 1 2\n" + "1 5 3", "4");
	}

	@Test
	void case2() {
		check("1 1 6\n" + "3 3 2", "1");
	}

	@Test
	void case3() {
		check("6 6 6\n" + "6 6 6", "2");
	}
}
