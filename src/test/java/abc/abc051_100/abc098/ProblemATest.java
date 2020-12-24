package abc.abc051_100.abc098;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 1", "4");
	}

	@Test
	void case2() {
		check("4 -2", "6");
	}

	@Test
	void case3() {
		check("0 0", "0");
	}
}
