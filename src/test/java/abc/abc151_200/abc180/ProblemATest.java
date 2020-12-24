package abc.abc151_200.abc180;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("100 1 2", "101");
	}

	@Test
	void case2() {
		check("100 2 1", "99");
	}

	@Test
	void case3() {
		check("100 1 1", "100");
	}
}
