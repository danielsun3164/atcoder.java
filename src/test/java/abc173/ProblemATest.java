package abc173;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1900", "100");
	}

	@Test
	void case2() {
		check("3000", "0");
	}
}
