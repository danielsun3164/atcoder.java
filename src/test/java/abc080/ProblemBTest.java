package abc080;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("12");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("57");
		ProblemB.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("148");
		ProblemB.main(null);
		assertResultIs("No");
	}
}
