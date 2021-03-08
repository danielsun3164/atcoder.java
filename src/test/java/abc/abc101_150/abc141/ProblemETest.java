package abc.abc101_150.abc141;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "ababa", "2");
	}

	@Test
	void case2() {
		check("2\n" + "xy", "0");
	}

	@Test
	void case3() {
		check("13\n" + "strangeorange", "5");
	}
}
