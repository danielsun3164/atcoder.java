package abc.abc101_150.abc136;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("RRLRL", "0 1 2 1 1");
	}

	@Test
	void case2() {
		check("RRLLLLRLRRLL", "0 3 3 0 0 0 1 1 0 2 2 0");
	}

	@Test
	void case3() {
		check("RRRLLRLLRRRLLLLL", "0 0 3 2 0 2 1 0 0 0 4 4 0 0 0 0");
	}
}
