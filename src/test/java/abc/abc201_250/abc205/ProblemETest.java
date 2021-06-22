package abc.abc201_250.abc205;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 3 1", "9");
	}

	@Test
	void case2() {
		check("1 0 0", "0");
	}

	@Test
	void case3() {
		check("1000000 1000000 1000000", "192151600");
	}
}
