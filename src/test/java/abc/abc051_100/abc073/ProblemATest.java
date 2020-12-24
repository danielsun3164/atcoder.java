package abc.abc051_100.abc073;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("29", "Yes");
	}

	@Test
	void case2() {
		check("72", "No");
	}

	@Test
	void case3() {
		check("91", "Yes");
	}
}
