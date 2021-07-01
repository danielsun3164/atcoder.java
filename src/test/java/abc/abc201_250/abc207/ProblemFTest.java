package abc.abc201_250.abc207;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 3\n" + "1 2", "1" + LF + "0" + LF + "2" + LF + "5");
	}

	@Test
	void case2() {
		check("5\n" + "1 3\n" + "4 5\n" + "1 5\n" + "2 3", "1" + LF + "0" + LF + "2" + LF + "5" + LF + "7" + LF + "17");
	}

	@Test
	void case3() {
		check("10\n" + "6 10\n" + "1 8\n" + "2 7\n" + "5 6\n" + "3 8\n" + "3 4\n" + "7 10\n" + "4 9\n" + "2 8",
				"1" + LF + "0" + LF + "3" + LF + "8" + LF + "15" + LF + "32" + LF + "68" + LF + "110" + LF + "196" + LF
						+ "266" + LF + "325");
	}
}
