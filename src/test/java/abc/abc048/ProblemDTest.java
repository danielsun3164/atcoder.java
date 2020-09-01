package abc.abc048;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("aba", "Second");
	}

	@Test
	void case2() {
		check("abc", "First");
	}

	@Test
	void case3() {
		check("abcab", "First");
	}
}
