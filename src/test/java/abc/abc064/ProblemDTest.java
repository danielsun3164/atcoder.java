package abc.abc064;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "())", "(())");
	}

	@Test
	void case2() {
		check("6\n" + ")))())", "(((()))())");
	}

	@Test
	void case3() {
		check("8\n" + "))))((((", "(((())))(((())))");
	}
}
