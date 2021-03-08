package abc.abc101_150.abc141;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("Sunny", "Cloudy");
	}

	@Test
	void case2() {
		check("Rainy", "Sunny");
	}

	@Test
	void case3() {
		check("Cloudy", "Rainy");
	}
}
