package abc.abc129;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 3 4", "4");
	}

	@Test
	void case2() {
		check("3 2 3", "5");
	}
}
