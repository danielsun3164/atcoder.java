package abc.abc003;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "2 2\n" + "2 2\n" + "3 2\n" + "2 2\n" + "2 2", "12");
	}

	@Test
	void case2() {
		check("4 5\n" + "3 1\n" + "3 0", "10");
	}

	@Test
	void case3() {
		check("23 18\n" + "15 13\n" + "100 95", "364527243");
	}

	@Test
	void case4() {
		check("30 30\n" + "24 22\n" + "145 132", "976668549");
	}
}
