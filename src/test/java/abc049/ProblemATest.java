package abc049;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("a");
		ProblemA.main(null);
		assertResultIs("vowel");
	}

	@Test
	void test_Case2() {
		in.input("z");
		ProblemA.main(null);
		assertResultIs("consonant");
	}

	@Test
	void test_Case3() {
		in.input("s");
		ProblemA.main(null);
		assertResultIs("consonant");
	}
}
