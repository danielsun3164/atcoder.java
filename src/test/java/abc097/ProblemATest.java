package abc097;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("4 7 9 3");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("100 10 1 2");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("10 10 10 1");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case4() {
		in.input("1 100 2 10");
		ProblemA.main(null);
		assertResultIs("Yes");
	}
}
