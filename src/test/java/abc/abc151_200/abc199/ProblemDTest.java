package abc.abc151_200.abc199;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "2 3\n" + "3 1", "6");
	}

	@Test
	void case2() {
		check("3 0", "27");
	}

	@Test
	void case3() {
		check("4 6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "2 4\n" + "1 3\n" + "1 4", "0");
	}

	@Test
	void case4() {
		check("20 0", "3486784401");
	}
}
