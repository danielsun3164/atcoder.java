package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem061Test extends TestBase {

	@Test
	void case1() {
		check("2", "First");
	}

	@Test
	void case2() {
		check("3", "Second");
	}

	@Test
	void case3() {
		check("1000000000000000000", "First");
	}
}
