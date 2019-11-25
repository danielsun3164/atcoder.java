package abc036;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("12 36");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("12 100");
		ProblemA.main(null);
		assertResultIs("9");
	}
}
