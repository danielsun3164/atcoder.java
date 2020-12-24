package abc.abc051_100.abc095;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1500 2000 1600 3 2", "7900");
	}

	@Test
	void case2() {
		check("1500 2000 1900 3 2", "8500");
	}

	@Test
	void case3() {
		check("1500 2000 500 90000 100000", "100000000");
	}
}
