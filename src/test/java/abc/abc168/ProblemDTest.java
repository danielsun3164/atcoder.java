package abc.abc168;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 4\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 2", "Yes" + LF + "1" + LF + "2" + LF + "2");
	}

	@Test
	void case2() {
		checkResultIn("6 9\n" + "3 4\n" + "6 1\n" + "2 4\n" + "5 3\n" + "4 6\n" + "1 5\n" + "6 2\n" + "4 5\n" + "5 6",
				"Yes" + LF + "6" + LF + "5" + LF + "5" + LF + "1" + LF + "1",
				"Yes" + LF + "6" + LF + "5" + LF + "6" + LF + "1" + LF + "1");
	}
}
