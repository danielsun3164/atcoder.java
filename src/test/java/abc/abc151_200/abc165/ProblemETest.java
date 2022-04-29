package abc.abc151_200.abc165;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 1", "2 3");
	}

	@Test
	void case2() {
		check("7 3", "1 3" + LF + "4 7" + LF + "5 6");
	}
}
