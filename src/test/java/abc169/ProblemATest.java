package abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 5", "10");
	}

	@Test
	void case2() {
		check("100 100", "10000");
	}
}
