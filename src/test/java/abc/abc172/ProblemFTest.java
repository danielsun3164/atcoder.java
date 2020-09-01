package abc.abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "5 3", "1");
	}

	@Test
	void case2() {
		check("2\n" + "3 5", "-1");
	}

	@Test
	void case3() {
		check("3\n" + "1 1 2", "-1");
	}

	@Test
	void case4() {
		check("8\n" + "10 9 8 7 6 5 4 3", "3");
	}

	@Test
	void case5() {
		check("3\n" + "4294967297 8589934593 12884901890", "1");
	}
}
