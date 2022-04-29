package abc.abc201_250.abc205;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "3 5 6 7\n" + "2\n" + "5\n" + "3", "2" + LF + "9" + LF + "4");
	}

	@Test
	void case2() {
		check("5 2\n" + "1 2 3 4 5\n" + "1\n" + "10", "6" + LF + "15");
	}

	@Test
	void case3() {
		check("4 4\n" + "1 3 5 7\n" + "1\n" + "2\n" + "3\n" + "4", "2" + LF + "4" + LF + "6\n" + "8");
	}

	@Test
	void case4() {
		check("4 7\n" + "1 4 7 10\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7",
				"2" + LF + "3" + LF + "5" + LF + "6" + LF + "8" + LF + "9" + LF + "11");
	}

	@Test
	void case5() {
		check("5 8\n" + "2 5 6 7 10\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "100000",
				"1" + LF + "3" + LF + "4" + LF + "8" + LF + "9" + LF + "11" + LF + "12" + LF + "100005");
	}
}
