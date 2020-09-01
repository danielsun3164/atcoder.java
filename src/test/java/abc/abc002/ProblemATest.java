package abc.abc002;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 11", "11");
	}

	@Test
	void case2() {
		check("100000000 10000000", "100000000");
	}
}
