package abc.abc151_200.abc175;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "4 4 9 7 5", "5");
	}

	@Test
	void case2() {
		check("6\n" + "4 5 4 3 3 5", "8");
	}

	@Test
	void case3() {
		check("10\n" + "9 4 6 1 9 6 10 6 6 8", "39");
	}

	@Test
	void case4() {
		check("2\n" + "1 1", "0");
	}
}
