package abc.abc051_100.abc083;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 20", "3");
	}

	@Test
	void case2() {
		check("25 100", "3");
	}

	@Test
	void case3() {
		check("314159265 358979323846264338", "31");
	}
}
