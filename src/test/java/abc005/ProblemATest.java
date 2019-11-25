package abc005;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("4 8");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("4 7");
		ProblemA.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("4 3");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
