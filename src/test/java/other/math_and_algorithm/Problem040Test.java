package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem040Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "8 6 9\n" + "6\n" + "2\n" + "1\n" + "3\n" + "2\n" + "3\n" + "4", "43");
	}
}
