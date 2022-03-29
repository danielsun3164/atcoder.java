package abc.abc201_250.abc213;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2\n" + "2 3", "2" + LF + "1");
	}

	@Test
	void case2() {
		check("5 6\n" + "1 2\n" + "1 4\n" + "1 5\n" + "2 3\n" + "2 5\n" + "3 4",
				"43" + LF + "31" + LF + "37" + LF + "41");
	}

	@Test
	void case3() {
		check("2 0", "0");
	}
}
