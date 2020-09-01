package abc.abc067;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "3 6\n" + "1 2\n" + "3 1\n" + "7 4\n" + "5 7\n" + "1 4", "Fennec");
	}

	@Test
	void case2() {
		check("4\n" + "1 4\n" + "4 2\n" + "2 3", "Snuke");
	}
}
