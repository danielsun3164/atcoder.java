package abc.abc201_250.abc214;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4 1 5\n" + "3 10 100", "3" + LF + "7" + LF + "8");
	}

	@Test
	void case2() {
		check("4\n" + "100 100 100 100\n" + "1 1 1 1", "1" + LF + "1" + LF + "1" + LF + "1");
	}

	@Test
	void case3() {
		check("4\n" + "1 2 3 4\n" + "1 2 4 7", "1" + LF + "2" + LF + "4" + LF + "7");
	}

	@Test
	void case4() {
		check("8\n" + "84 87 78 16 94 36 87 93\n" + "50 22 63 28 91 60 64 27",
				"50" + LF + "22" + LF + "63" + LF + "28" + LF + "44" + LF + "60" + LF + "64" + LF + "27");
	}
}
