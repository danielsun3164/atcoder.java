package abc.abc175;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "2 4 5 1 3\n" + "3 4 -10 -8 8", "8");
	}

	@Test
	void case2() {
		check("2 3\n" + "2 1\n" + "10 -7", "13");
	}

	@Test
	void case3() {
		check("3 3\n" + "3 1 2\n" + "-1000 -2000 -3000", "-1000");
	}

	@Test
	void case4() {
		check("10 58\n" + "9 1 6 7 8 4 3 2 10 5\n"
				+ "695279662 988782657 -119067776 382975538 -151885171 -177220596 -169777795 37619092 389386780 980092719",
				"29507023469");
	}
}
