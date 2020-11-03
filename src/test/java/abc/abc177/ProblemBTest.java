package abc.abc177;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("cabacc\n" + "abc", "1");
	}

	@Test
	void case2() {
		check("codeforces\n" + "atcoder", "6");
	}
}
