package abc080;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("7 17 120");
		ProblemA.main(null);
		assertResultIs("119");
	}

	@Test
	void case2() {
		in.input("5 20 100");
		ProblemA.main(null);
		assertResultIs("100");
	}

	@Test
	void case3() {
		in.input("6 18 100");
		ProblemA.main(null);
		assertResultIs("100");
	}
}
