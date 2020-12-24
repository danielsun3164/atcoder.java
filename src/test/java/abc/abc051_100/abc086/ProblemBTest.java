package abc.abc051_100.abc086;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 21", "Yes");
	}

	@Test
	void case2() {
		check("100 100", "No");
	}

	@Test
	void case3() {
		check("12 10", "No");
	}
}
