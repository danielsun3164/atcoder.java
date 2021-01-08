package abc.abc051_100.abc082;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 3", "2");
	}

	@Test
	void case2() {
		check("7 4", "6");
	}

	@Test
	void case3() {
		check("5 5", "5");
	}
}
