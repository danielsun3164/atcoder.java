package abc023;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "abc");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("6\n" + "abcabc");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void test_Case3() {
		in.input("7\n" + "atcoder");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void test_Case4() {
		in.input("19\n" + "bcabcabcabcabcabcab");
		ProblemB.main(null);
		assertResultIs("9");
	}
}
