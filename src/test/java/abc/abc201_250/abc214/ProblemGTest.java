package abc.abc201_250.abc214;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2 3 4\n" + "2 1 4 3", "4");
	}

	@Test
	void case2() {
		check("3\n" + "1 2 3\n" + "2 1 3", "0");
	}

	@Test
	void case3() {
		check("20\n" + "2 3 15 19 10 7 5 6 14 13 20 4 18 9 17 8 12 11 16 1\n"
				+ "8 12 4 13 19 3 10 16 11 9 1 2 17 6 5 18 7 14 20 15", "803776944");
	}
}
