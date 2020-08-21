package abc101;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
