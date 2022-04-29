package abc.abc151_200.abc160;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "1 3", "2" + LF + "1" + LF + "1");
	}

	@Test
	void case2() {
		check("2\n" + "1 2", "1" + LF + "1");
	}

	@Test
	void case3() {
		check("5\n" + "1 2\n" + "2 3\n" + "3 4\n" + "3 5", "2" + LF + "8" + LF + "12" + LF + "3" + LF + "3");
	}

	@Test
	void case4() {
		check("8\n" + "1 2\n" + "2 3\n" + "3 4\n" + "3 5\n" + "3 6\n" + "6 7\n" + "6 8",
				"40" + LF + "280" + LF + "840" + LF + "120" + LF + "120" + LF + "504" + LF + "72" + LF + "72");
	}
}
