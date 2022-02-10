package abc.abc151_200.abc156;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 1 3", "7");
	}

	@Test
	void case2() {
		check("1000000000 141421 173205", "34076506");
	}
}
