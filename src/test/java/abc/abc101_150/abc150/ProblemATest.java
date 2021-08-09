package abc.abc101_150.abc150;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 900", "Yes");
	}

	@Test
	void case2() {
		check("1 501", "No");
	}

	@Test
	void case3() {
		check("4 2000", "Yes");
	}
}
