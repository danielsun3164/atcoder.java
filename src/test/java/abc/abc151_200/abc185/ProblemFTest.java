package abc.abc151_200.abc185;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "1 2 3\n" + "2 1 3\n" + "2 2 3\n" + "1 2 3\n" + "2 2 3", "0" + LF + "1" + LF + "2");
	}

	@Test
	void case2() {
		check("10 10\n" + "0 5 3 4 7 0 0 0 1 0\n" + "1 10 7\n" + "2 8 9\n" + "2 3 6\n" + "2 1 6\n" + "2 1 10\n"
				+ "1 9 4\n" + "1 6 1\n" + "1 6 3\n" + "1 1 7\n" + "2 3 5",
				"1" + LF + "0" + LF + "5" + LF + "3" + LF + "0");
	}
}
