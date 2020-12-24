package abc.abc051_100.abc093;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 5 4", "2");
	}

	@Test
	void case2() {
		check("2 6 3", "5");
	}

	@Test
	void case3() {
		check("31 41 5", "23");
	}
}
