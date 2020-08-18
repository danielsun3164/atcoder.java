package abc097;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("10");
		ProblemB.main(null);
		assertResultIs("9");
	}

	@Test
	void case2() {
		in.input("1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("999");
		ProblemB.main(null);
		assertResultIs("961");
	}
}
