package abc009;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "abc");
		ProblemC.main(null);
		assertResultIs("abc");
	}

	@Test
	void case2() {
		in.input("7 2\n" + "atcoder");
		ProblemC.main(null);
		assertResultIs("actoder");
	}

	@Test
	void case3() {
		in.input("7 7\n" + "atcoder");
		ProblemC.main(null);
		assertResultIs("acdeort");
	}

	@Test
	void case4() {
		in.input("10 3\n" + "helloworld");
		ProblemC.main(null);
		assertResultIs("dehloworll");
	}
}
