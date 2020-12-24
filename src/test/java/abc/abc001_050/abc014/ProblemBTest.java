package abc.abc001_050.abc014;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "1 10 100 1000", "101");
	}

	@Test
	void case2() {
		check("20 1048575\n" + "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20", "210");
	}

	@Test
	void case3() {
		check("4 0\n" + "1000 1000 1000 1000", "0");
	}
}
