package abc173;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1900");
		ProblemA.main(null);
		assertResultIs("100");
	}

	@Test
	void case2() {
		in.input("3000");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
