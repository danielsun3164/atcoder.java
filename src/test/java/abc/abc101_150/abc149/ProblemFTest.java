package abc.abc101_150.abc149;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "2 3", "125000001");
	}

	@Test
	void case2() {
		check("4\n" + "1 2\n" + "2 3\n" + "3 4", "375000003");
	}

	@Test
	void case3() {
		check("4\n" + "1 2\n" + "1 3\n" + "1 4", "250000002");
	}

	@Test
	void case4() {
		check("7\n" + "4 7\n" + "3 1\n" + "2 6\n" + "5 2\n" + "7 1\n" + "2 7", "570312505");
	}
}
