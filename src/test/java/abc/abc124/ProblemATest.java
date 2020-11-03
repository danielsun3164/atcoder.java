package abc.abc124;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 3", "9");
	}

	@Test
	void case2() {
		check("3 4", "7");
	}

	@Test
	void case3() {
		check("6 6", "12");
	}
}
