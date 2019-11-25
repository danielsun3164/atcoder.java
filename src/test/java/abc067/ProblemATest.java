package abc067;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("4 5");
		ProblemA.main(null);
		assertResultIs("Possible");
	}

	@Test
	void case2() {
		in.input("1 1");
		ProblemA.main(null);
		assertResultIs("Impossible");
	}
}
