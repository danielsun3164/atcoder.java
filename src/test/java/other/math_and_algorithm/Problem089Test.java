package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem089Test extends TestBase {

	@Test
	void case1() {
		check("4 3 2", "Yes");
	}

	@Test
	void case2() {
		check("16 3 2", "No");
	}

	@Test
	void case3() {
		check("8 3 2", "No");
	}

	@Test
	void case4() {
		check("1000000000000000000 1000000000000000000 1000000000000000000", "Yes");
	}

	@Test
	void case5() {
		check("869120 5 15", "No");
	}
}
