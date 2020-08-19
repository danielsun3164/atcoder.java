package abc093;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("bac", "Yes");
	}

	@Test
	void case2() {
		check("bab", "No");
	}

	@Test
	void case3() {
		check("abc", "Yes");
	}

	@Test
	void case4() {
		check("aaa", "No");
	}
}
