package abc099;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "0 1 1\n" + "1 0 1\n" + "1 4 0\n" + "1 2\n" + "3 3", "3");
	}

	@Test
	void case2() {
		check("4 3\n" + "0 12 71\n" + "81 0 53\n" + "14 92 0\n" + "1 1 2 1\n" + "2 1 1 2\n" + "2 2 1 3\n" + "1 1 2 2",
				"428");
	}
}
