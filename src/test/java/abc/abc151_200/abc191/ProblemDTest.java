package abc.abc151_200.abc191;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("0.2 0.8 1.1", "3");
	}

	@Test
	void case2() {
		check("100 100 1", "5");
	}

	@Test
	void case3() {
		check("42782.4720 31949.0192 99999.99", "31415920098");
	}
}
