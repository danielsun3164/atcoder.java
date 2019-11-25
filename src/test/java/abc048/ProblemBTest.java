package abc048;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("4 8 2");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("0 5 1");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void case3() {
		in.input("9 9 2");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("1 1000000000000000000 3");
		ProblemB.main(null);
		assertResultIs("333333333333333333");
	}
}
