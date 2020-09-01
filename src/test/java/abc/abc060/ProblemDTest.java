package abc.abc060;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 6\n" + "2 1\n" + "3 4\n" + "4 10\n" + "3 4", "11");
	}

	@Test
	void case2() {
		check("4 6\n" + "2 1\n" + "3 7\n" + "4 10\n" + "3 6", "13");
	}

	@Test
	void case3() {
		check("4 10\n" + "1 100\n" + "1 100\n" + "1 100\n" + "1 100", "400");
	}

	@Test
	void case4() {
		check("4 1\n" + "10 100\n" + "10 100\n" + "10 100\n" + "10 100", "0");
	}
}
