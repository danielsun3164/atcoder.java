package abc.abc101_150.abc149;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3 3", "0 2");
	}

	@Test
	void case2() {
		check("500000000000 500000000000 1000000000000", "0 0");
	}
}
