package abc.abc023;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "abc", "1");
	}

	@Test
	void case2() {
		check("6\n" + "abcabc", "-1");
	}

	@Test
	void case3() {
		check("7\n" + "atcoder", "-1");
	}

	@Test
	void case4() {
		check("19\n" + "bcabcabcabcabcabcab", "9");
	}
}
