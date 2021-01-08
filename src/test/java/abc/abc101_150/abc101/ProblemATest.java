package abc.abc101_150.abc101;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("+-++", "2");
	}

	@Test
	void case2() {
		check("-+--", "-2");
	}

	@Test
	void case3() {
		check("----", "-4");
	}
}
