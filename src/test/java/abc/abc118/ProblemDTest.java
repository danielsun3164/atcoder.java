package abc.abc118;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("20 4\n" + "3 7 8 4", "777773");
	}

	@Test
	void case2() {
		check("101 9\n" + "9 8 7 6 5 4 3 2 1", "71111111111111111111111111111111111111111111111111");
	}

	@Test
	void case3() {
		check("15 3\n" + "5 4 6", "654");
	}
}
