package abc.abc093;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 8 2", "3" + LF + "4" + LF + "7" + LF + "8");
	}

	@Test
	void case2() {
		check("4 8 3", "4" + LF + "5" + LF + "6" + LF + "7" + LF + "8");
	}

	@Test
	void case3() {
		check("2 9 100", "2" + LF + "3" + LF + "4" + LF + "5" + LF + "6" + LF + "7" + LF + "8" + LF + "9");
	}
}
