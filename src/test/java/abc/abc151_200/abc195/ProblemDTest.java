package abc.abc151_200.abc195;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 4 3\n" + "1 9\n" + "5 3\n" + "7 8\n" + "1 8 6 9\n" + "4 4\n" + "1 4\n" + "1 3",
				"20" + LF + "0" + LF + "9");
	}

	@Test
	void case2() {
		check("3 4 3\n" + "1 9\n" + "5 3\n" + "7 8\n" + "1 7 5 9\n" + "4 4\n" + "1 4\n" + "1 3",
				"20" + LF + "0" + LF + "9");
	}
}
