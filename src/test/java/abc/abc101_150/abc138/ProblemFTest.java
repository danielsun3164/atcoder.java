package abc.abc101_150.abc138;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2 3", "3");
	}

	@Test
	void case2() {
		check("10 100", "604");
	}

	@Test
	void case3() {
		check("1 1000000000000000000", "68038601");
	}
}
