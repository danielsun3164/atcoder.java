package abc062;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 1 4 1 5 9", "1");
	}

	@Test
	void case2() {
		check("1\n" + "1 2 3", "-1");
	}

	@Test
	void case3() {
		check("3\n" + "8 2 2 7 4 6 5 3 8", "5");
	}
}
