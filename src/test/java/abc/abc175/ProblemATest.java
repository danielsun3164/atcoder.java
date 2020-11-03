package abc.abc175;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("RRS", "2");
	}

	@Test
	void case2() {
		check("SSS", "0");
	}

	@Test
	void case3() {
		check("RSR", "1");
	}
}
