package abc048;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("aba");
		ProblemD.main(null);
		assertResultIs("Second");
	}

	@Test
	void test_Case2() {
		in.input("abc");
		ProblemD.main(null);
		assertResultIs("First");
	}

	@Test
	void test_Case3() {
		in.input("abcab");
		ProblemD.main(null);
		assertResultIs("First");
	}
}
