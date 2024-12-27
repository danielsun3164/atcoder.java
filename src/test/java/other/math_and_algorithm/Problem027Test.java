package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem027Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3 1 2", "1 2 3");
	}

	@Test
	void case2() {
		check("10\n" + "658 299 47 507 122 969 449 68 513 800", "47 68 122 299 449 507 513 658 800 969");
	}
}
