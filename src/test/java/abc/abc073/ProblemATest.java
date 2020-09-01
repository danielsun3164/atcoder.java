package abc.abc073;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
