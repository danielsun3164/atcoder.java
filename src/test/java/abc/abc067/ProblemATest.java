package abc.abc067;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 5", "Possible");
	}

	@Test
	void case2() {
		check("1 1", "Impossible");
	}
}
