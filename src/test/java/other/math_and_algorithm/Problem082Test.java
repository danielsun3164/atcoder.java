package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem082Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "123 86399\n" + "1 86400\n" + "86399 86400", "2");
	}
}
