package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem047Test extends TestBase {

	@Test
	void case1() {
		check("8 7\n" + "1 5\n" + "1 6\n" + "2 7\n" + "3 7\n" + "4 6\n" + "5 8\n" + "6 8", "Yes");
	}

	@Test
	void case2() {
		check("6 7\n" + "1 6\n" + "2 6\n" + "3 6\n" + "2 4\n" + "3 5\n" + "1 3\n" + "1 4", "No");
	}
}
