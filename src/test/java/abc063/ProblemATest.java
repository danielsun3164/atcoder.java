package abc063;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("6 3", "9");
	}

	@Test
	void case2() {
		check("6 4", "error");
	}
}
