package abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2 5");
		ProblemA.main(null);
		assertResultIs("10");
	}

	@Test
	void case2() {
		in.input("100 100");
		ProblemA.main(null);
		assertResultIs("10000");
	}
}
