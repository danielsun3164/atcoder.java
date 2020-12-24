package abc.abc101_150.abc112;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 14", "2");
	}

	@Test
	void case2() {
		check("10 123", "3");
	}

	@Test
	void case3() {
		check("100000 1000000000", "10000");
	}
}
