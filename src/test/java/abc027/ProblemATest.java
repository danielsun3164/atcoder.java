package abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1 1 2");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("4 3 4");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("5 5 5");
		ProblemA.main(null);
		assertResultIs("5");
	}
}
