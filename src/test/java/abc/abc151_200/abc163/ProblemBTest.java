package abc.abc151_200.abc163;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("41 2\n" + "5 6", "30");
	}

	@Test
	void case2() {
		check("10 2\n" + "5 6", "-1");
	}

	@Test
	void case3() {
		check("11 2\n" + "5 6", "0");
	}

	@Test
	void case4() {
		check("314 15\n" + "9 26 5 35 8 9 79 3 23 8 46 2 6 43 3", "9");
	}
}
