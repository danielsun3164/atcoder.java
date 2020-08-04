package abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2");
		ProblemA.main(null);
		assertResultIs("14");
	}

	@Test
	void case2() {
		in.input("10");
		ProblemA.main(null);
		assertResultIs("1110");
	}
}
