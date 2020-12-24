package abc.abc001_050.abc036;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3\n" + "3\n" + "1\n" + "6\n" + "1", "1" + LF + "1" + LF + "0" + LF + "2" + LF + "0");
	}

	@Test
	void case2() {
		check("5\n" + "3\n" + "2\n" + "1\n" + "6\n" + "4", "2" + LF + "1" + LF + "0" + LF + "4" + LF + "3");
	}
}
