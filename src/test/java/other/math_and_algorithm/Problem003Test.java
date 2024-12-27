package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem003Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3 1 4 1 5", "14");
	}

	@Test
	void case2() {
		check("3\n" + "10 20 50", "80");
	}

	@Test
	void case3() {
		check("10\n" + "1 2 3 4 5 6 7 8 9 10", "55");
	}
}
