package abc.abc186;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 3", "3");
	}

	@Test
	void case2() {
		check("1000 1", "1000");
	}
}
