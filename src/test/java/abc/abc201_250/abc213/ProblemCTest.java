package abc.abc201_250.abc213;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 5 2\n" + "3 2\n" + "2 5", "2 1" + LF + "1 2");
	}

	@Test
	void case2() {
		check("1000000000 1000000000 10\n" + "1 1\n" + "10 10\n" + "100 100\n" + "1000 1000\n" + "10000 10000\n"
				+ "100000 100000\n" + "1000000 1000000\n" + "10000000 10000000\n" + "100000000 100000000\n"
				+ "1000000000 1000000000",
				"1 1" + LF + "2 2" + LF + "3 3" + LF + "4 4" + LF + "5 5" + LF + "6 6" + LF + "7 7" + LF + "8 8" + LF
						+ "9 9" + LF + "10 10");
	}
}
