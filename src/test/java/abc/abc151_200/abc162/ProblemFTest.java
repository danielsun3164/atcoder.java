package abc.abc151_200.abc162;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 2 3 4 5 6", "12");
	}

	@Test
	void case2() {
		check("5\n" + "-1000 -100 -10 0 10", "0");
	}

	@Test
	void case3() {
		check("10\n"
				+ "1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000",
				"5000000000");
	}

	@Test
	void case4() {
		check("27\n" + "18 -28 18 28 -45 90 -45 23 -53 60 28 -74 -71 35 -26 -62 49 -77 57 24 -70 -93 69 -99 59 57 -49",
				"295");
	}
}
