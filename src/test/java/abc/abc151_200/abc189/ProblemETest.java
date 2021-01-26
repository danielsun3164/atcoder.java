package abc.abc151_200.abc189;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "1 2\n" + "4\n" + "1\n" + "3 3\n" + "2\n" + "4 2\n" + "5\n" + "0 1\n" + "1 1\n" + "2 1\n"
				+ "3 1\n" + "4 1", "1 2" + LF + "2 -1" + LF + "4 -1" + LF + "1 4" + LF + "1 0");
	}

	@Test
	void case2() {
		check("2\n" + "1000000000 0\n" + "0 1000000000\n" + "4\n" + "3 -1000000000\n" + "4 -1000000000\n"
				+ "3 1000000000\n" + "4 1000000000\n" + "2\n" + "4 1\n" + "4 2",
				"5000000000 4000000000" + LF + "4000000000 5000000000");
	}
}
