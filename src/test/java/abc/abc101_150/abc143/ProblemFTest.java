package abc.abc101_150.abc143;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 1 2", "3" + LF + "1" + LF + "0");
	}

	@Test
	void case2() {
		check("5\n" + "1 2 3 4 5", "5" + LF + "2" + LF + "1" + LF + "1" + LF + "1");
	}

	@Test
	void case3() {
		check("4\n" + "1 3 3 3", "4" + LF + "1" + LF + "0" + LF + "0");
	}
}
