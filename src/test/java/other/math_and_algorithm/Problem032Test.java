package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem032Test extends TestBase {

	@Test
	void case1() {
		check("7 3\n" + "1 2 3 4 5 6 7", "Yes");
	}

	@Test
	void case2() {
		check("7 9\n" + "1 2 3 4 5 6 7", "No");
	}

	@Test
	void case3() {
		check("7 1\n" + "2 3 4 5 6 7 8", "No");
	}
}
