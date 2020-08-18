package abc098;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3 1");
		ProblemA.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("4 -2");
		ProblemA.main(null);
		assertResultIs("6");
	}

	@Test
	void case3() {
		in.input("0 0");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
