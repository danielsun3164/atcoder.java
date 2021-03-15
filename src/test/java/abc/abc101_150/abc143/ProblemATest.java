package abc.abc101_150.abc143;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("12 4", "4");
	}

	@Test
	void case2() {
		check("20 15", "0");
	}

	@Test
	void case3() {
		check("20 30", "0");
	}
}
