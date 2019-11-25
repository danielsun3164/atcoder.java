package abc032;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("abcabc\n" + "2");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("aaaaa\n" + "1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("hello\n" + "10");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
