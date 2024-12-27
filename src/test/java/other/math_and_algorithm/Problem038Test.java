package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem038Test extends TestBase {

	@Test
	void case1() {
		check("10 5\n" + "8 6 9 1 2 1 10 100 1000 10000\n" + "2 3\n" + "1 4\n" + "3 9\n" + "6 8\n" + "1 10",
				"15" + LF + "24" + LF + "1123" + LF + "111" + LF + "11137");
	}
}
