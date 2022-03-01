package abc.abc151_200.abc163;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5" + LF + "1 1 2 2", "2" + LF + "2" + LF + "0" + LF + "0" + LF + "0");
	}

	@Test
	void case2() {
		check("10" + LF + "1 1 1 1 1 1 1 1 1",
				"9" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@Test
	void case3() {
		check("7\n" + "1 2 3 4 5 6", "1" + LF + "1" + LF + "1" + LF + "1" + LF + "1" + LF + "1" + LF + "0");
	}
}
