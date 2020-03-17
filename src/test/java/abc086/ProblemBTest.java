package abc086;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("1 21");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("100 100");
		ProblemB.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("12 10");
		ProblemB.main(null);
		assertResultIs("No");
	}
}
