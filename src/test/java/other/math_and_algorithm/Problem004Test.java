package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem004Test extends TestBase {

	@Test
	void case1() {
		check("2 8 8", "128");
	}

	@Test
	void case2() {
		check("7 7 25", "1225");
	}

	@Test
	void case3() {
		check("100 100 100", "1000000");
	}
}
