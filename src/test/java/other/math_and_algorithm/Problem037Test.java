package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem037Test extends TestBase {

	@Test
	void case1() {
		check("1 1\n" + "2 2\n" + "1 2\n" + "2 1", "Yes");
	}

	@Test
	void case2() {
		check("1 2\n" + "2 2\n" + "1 1\n" + "1 3", "Yes");
	}

	@Test
	void case3() {
		check("100000001 200000000\n" + "200000000 200000000\n" + "100000000 100000000\n" + "100000000 300000000",
				"No");
	}

	@Test
	void case4() {
		check("1 1\n" + "3 3\n" + "2 2\n" + "4 4", "Yes");
	}

	@Test
	void case5() {
		check("4 1\n" + "3 2\n" + "2 3\n" + "1 4", "No");
	}
}
