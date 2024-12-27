package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem005Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "30 50 70", "50");
	}

	@Test
	void case2() {
		check("10\n" + "1 2 3 4 5 6 7 8 9 10", "55");
	}

	@Test
	void case3() {
		check("5\n" + "60 60 60 60 60", "0");
	}
}
