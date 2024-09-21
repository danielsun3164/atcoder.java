package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem078Test extends TestBase {

	@Test
	void case1() {
		check("6 7\n" + "1 2\n" + "1 3\n" + "2 4\n" + "2 5\n" + "3 4\n" + "4 6\n" + "5 6",
				"0" + LF + "1" + LF + "1" + LF + "2" + LF + "2" + LF + "3");
	}
}
