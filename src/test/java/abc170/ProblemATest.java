package abc170;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("0 2 3 4 5", "1");
	}

	@Test
	void case2() {
		check("1 2 0 4 5", "3");
	}
}
