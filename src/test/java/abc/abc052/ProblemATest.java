package abc.abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 5 2 7", "15");
	}

	@Test
	void case2() {
		check("100 600 200 300", "60000");
	}
}
