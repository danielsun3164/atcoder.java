package abc.abc023;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "5 6\n" + "12 4\n" + "14 7\n" + "21 2", "23");
	}

	@Test
	void case2() {
		check("6\n" + "100 1\n" + "100 1\n" + "100 1\n" + "100 1\n" + "100 1\n" + "1 30", "105");
	}
}
