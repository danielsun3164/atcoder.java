package abc.abc151_200.abc180;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 20 2 10", "2");
	}

	@Test
	void case2() {
		check("1 1000000000000000000 10 1000000000", "1000000007");
	}
}
