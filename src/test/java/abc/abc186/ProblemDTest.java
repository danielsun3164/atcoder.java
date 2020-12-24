package abc.abc186;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 1 2", "8");
	}

	@Test
	void case2() {
		check("5\n" + "31 41 59 26 53", "176");
	}
}
