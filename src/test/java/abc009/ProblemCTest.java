package abc009;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 2\n" + "abc");
		ProblemC.main(null);
		assertResultIs("abc");
	}

	@Test
	void test_Case2() {
		in.input("7 2\n" + "atcoder");
		ProblemC.main(null);
		assertResultIs("actoder");
	}

	@Test
	void test_Case3() {
		in.input("7 7\n" + "atcoder");
		ProblemC.main(null);
		assertResultIs("acdeort");
	}

	@Test
	void test_Case4() {
		in.input("10 3\n" + "helloworld");
		ProblemC.main(null);
		assertResultIs("dehloworll");
	}
}
