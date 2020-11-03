package abc.abc125;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "10 2 5\n" + "6 3 4", "5");
	}

	@Test
	void case2() {
		check("4\n" + "13 21 6 19\n" + "11 30 6 15", "6");
	}

	@Test
	void case3() {
		check("1\n" + "1\n" + "50", "0");
	}
}
