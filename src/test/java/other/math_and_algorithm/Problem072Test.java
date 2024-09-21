package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem072Test extends TestBase {

	@Test
	void case1() {
		check("2 4", "2");
	}

	@Test
	void case2() {
		check("199999 200000", "1");
	}

	@Test
	void case3() {
		check("101 139", "34");
	}
}
