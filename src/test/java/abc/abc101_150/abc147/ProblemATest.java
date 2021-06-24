package abc.abc101_150.abc147;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 7 9", "win");
	}

	@Test
	void case2() {
		check("13 7 2", "bust");
	}
}
