package abc.abc051_100.abc090;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "0");
	}

	@Test
	void case2() {
		check("1 7", "5");
	}

	@Test
	void case3() {
		check("314 1592", "496080");
	}
}
