package abc.abc151_200.abc164;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 5", "unsafe");
	}

	@Test
	void case2() {
		check("100 2", "safe");
	}

	@Test
	void case3() {
		check("10 10", "unsafe");
	}
}
