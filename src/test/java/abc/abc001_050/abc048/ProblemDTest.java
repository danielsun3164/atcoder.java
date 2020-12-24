package abc.abc001_050.abc048;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

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
