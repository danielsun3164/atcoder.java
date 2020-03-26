package abc093;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("bac");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("bab");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("abc");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case4() {
		in.input("aaa");
		ProblemA.main(null);
		assertResultIs("No");
	}
}
