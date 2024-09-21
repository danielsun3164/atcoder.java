package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem098Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 0\n" + "3 1\n" + "2 3\n" + "0 3\n" + "2 1", "INSIDE");
	}

	@Test
	void case2() {
		check("4\n" + "3 1\n" + "0 0\n" + "0 3\n" + "2 3\n" + "3 2", "OUTSIDE");
	}

	@Test
	void case3() {
		check("6\n" + "5 5\n" + "-1 -3\n" + "5 1\n" + "-3 -5\n" + "1 1\n" + "-5 -3\n" + "0 -1", "INSIDE");
	}

	@Test
	void case4() {
		check("16\n" + "0 0\n" + "8 0\n" + "8 7\n" + "7 7\n" + "7 1\n" + "1 1\n" + "1 6\n" + "5 6\n" + "5 3\n" + "3 3\n"
				+ "3 5\n" + "2 5\n" + "2 2\n" + "6 2\n" + "6 7\n" + "0 7\n" + "4 4", "OUTSIDE");
	}

	@Test
	void case5() {
		check("3\n" + "0 0\n" + "1000000000 671903261\n" + "671903261 1000000000\n" + "520908341 350000013", "OUTSIDE");
	}
}
