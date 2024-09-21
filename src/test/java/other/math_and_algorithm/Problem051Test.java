package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem051Test extends TestBase {

	@Test
	void case1() {
		check("1 2", "3");
	}

	@Test
	void case2() {
		check("869 120", "445891023");
	}
}
