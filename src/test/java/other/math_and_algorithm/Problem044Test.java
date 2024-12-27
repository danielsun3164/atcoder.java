package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem044Test extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 3\n" + "2 3", "0" + LF + "2" + LF + "1");
	}

	@Test
	void case2() {
		check("6 6\n" + "1 4\n" + "2 3\n" + "3 4\n" + "5 6\n" + "1 2\n" + "2 4",
				"0" + LF + "1" + LF + "2" + LF + "1" + LF + "-1" + LF + "-1");
	}
}
