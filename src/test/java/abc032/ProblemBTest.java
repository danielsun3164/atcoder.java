package abc032;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("abcabc\n" + "2");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("aaaaa\n" + "1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case3() {
		in.input("hello\n" + "10");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
