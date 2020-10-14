package abc.abc094;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "6 9 4 2 11", "11 6");
	}

	@Test
	void case2() {
		check("2\n" + "100 0", "100 0");
	}
}
