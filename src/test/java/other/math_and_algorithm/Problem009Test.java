package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem009Test extends TestBase {

	@Test
	void case1() {
		check("3 11\n" + "2 5 9", "Yes");
	}

	@Test
	void case2() {
		check("4 11\n" + "3 1 4 5", "No");
	}
}
