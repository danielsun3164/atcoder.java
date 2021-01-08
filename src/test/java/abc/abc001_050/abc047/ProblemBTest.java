package abc.abc001_050.abc047;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 4 2\n" + "2 1 1\n" + "3 3 4", "9");
	}

	@Test
	void case2() {
		check("5 4 3\n" + "2 1 1\n" + "3 3 4\n" + "1 4 2", "0");
	}

	@Test
	void case3() {
		check("10 10 5\n" + "1 6 1\n" + "4 1 3\n" + "6 9 4\n" + "9 4 2\n" + "3 1 3", "64");
	}
}
