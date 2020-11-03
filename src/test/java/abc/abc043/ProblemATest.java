package abc.abc043;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3", "6");
	}

	@Test
	void case2() {
		check("10", "55");
	}

	@Test
	void case3() {
		check("1", "1");
	}
}
