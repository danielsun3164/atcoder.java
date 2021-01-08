package abc.abc051_100.abc065;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "8");
	}

	@Test
	void case2() {
		check("3 2", "12");
	}

	@Test
	void case3() {
		check("1 8", "0");
	}

	@Test
	void case4() {
		check("100000 100000", "530123477");
	}
}
