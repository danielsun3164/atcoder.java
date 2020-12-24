package abc.abc051_100.abc097;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 7 9 3", "Yes");
	}

	@Test
	void case2() {
		check("100 10 1 2", "No");
	}

	@Test
	void case3() {
		check("10 10 10 1", "Yes");
	}

	@Test
	void case4() {
		check("1 100 2 10", "Yes");
	}
}
