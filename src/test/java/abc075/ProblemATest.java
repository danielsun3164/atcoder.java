package abc075;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("5 7 5");
		ProblemA.main(null);
		assertResultIs("7");
	}

	@Test
	void case2() {
		in.input("1 1 7");
		ProblemA.main(null);
		assertResultIs("7");
	}

	@Test
	void case3() {
		in.input("-100 100 100");
		ProblemA.main(null);
		assertResultIs("-100");
	}
}
