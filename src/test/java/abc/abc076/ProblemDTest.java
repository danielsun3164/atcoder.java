package abc.abc076;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "100\n" + "30", 2100.0d);
	}

	@Test
	void case2() {
		check("2\n" + "60 50\n" + "34 38", 2632.0d);
	}

	@Test
	void case3() {
		check("3\n" + "12 14 2\n" + "6 2 7", 76.0d);
	}

	@Test
	void case4() {
		check("1\n" + "9\n" + "10", 20.25d);
	}

	@Test
	void case5() {
		check("10\n" + "64 55 27 35 76 119 7 18 49 100\n" + "29 19 31 39 27 48 41 87 55 70", 20291.0d);
	}
}
