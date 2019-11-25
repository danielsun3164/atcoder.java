package abc023;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "abc");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("6\n" + "abcabc");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void case3() {
		in.input("7\n" + "atcoder");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void case4() {
		in.input("19\n" + "bcabcabcabcabcabcab");
		ProblemB.main(null);
		assertResultIs("9");
	}
}
