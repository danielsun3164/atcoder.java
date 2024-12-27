package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem057Test extends TestBase {

	@Test
	void case1() {
		check("2 6", "13");
	}

	@Test
	void case2() {
		check("3 8", "153");
	}

	@Test
	void case3() {
		check("4 7", "781");
	}
}
