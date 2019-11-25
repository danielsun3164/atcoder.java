package abc030;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("5 2 6 3");
		ProblemA.main(null);
		assertResultIs("AOKI");
	}

	@Test
	void case2() {
		in.input("100 80 100 73");
		ProblemA.main(null);
		assertResultIs("TAKAHASHI");
	}

	@Test
	void case3() {
		in.input("66 30 55 25");
		ProblemA.main(null);
		assertResultIs("DRAW");
	}
}
