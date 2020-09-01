package abc.abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 2 7", "B");
	}

	@Test
	void case2() {
		check("1 999 1000", "A");
	}
}
