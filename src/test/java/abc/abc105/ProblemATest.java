package abc.abc105;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7 3", "1");
	}

	@Test
	void case2() {
		check("100 10", "0");
	}

	@Test
	void case3() {
		check("1 1", "0");
	}
}
