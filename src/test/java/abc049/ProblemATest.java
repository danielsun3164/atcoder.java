package abc049;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("a");
		ProblemA.main(null);
		assertResultIs("vowel");
	}

	@Test
	void case2() {
		in.input("z");
		ProblemA.main(null);
		assertResultIs("consonant");
	}

	@Test
	void case3() {
		in.input("s");
		ProblemA.main(null);
		assertResultIs("consonant");
	}
}
