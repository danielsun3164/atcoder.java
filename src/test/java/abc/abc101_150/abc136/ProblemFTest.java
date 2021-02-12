package abc.abc101_150.abc136;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "-1 3\n" + "2 1\n" + "3 -2", "13");
	}

	@Test
	void case2() {
		check("4\n" + "1 4\n" + "2 1\n" + "3 3\n" + "4 2", "34");
	}

	@Test
	void case3() {
		check("10\n" + "19 -11\n" + "-3 -12\n" + "5 3\n" + "3 -15\n" + "8 -14\n" + "-9 -20\n" + "10 -9\n" + "0 2\n"
				+ "-7 17\n" + "6 -6", "7222");
	}
}
