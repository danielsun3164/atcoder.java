package abc175;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("RRS");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("SSS");
		ProblemA.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("RSR");
		ProblemA.main(null);
		assertResultIs("1");
	}
}
