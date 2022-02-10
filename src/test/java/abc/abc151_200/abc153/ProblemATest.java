package abc.abc151_200.abc153;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 4", "3");
	}

	@Test
	void case2() {
		check("1 10000", "1");
	}

	@Test
	void case3() {
		check("10000 1", "10000");
	}
}
