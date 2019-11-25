package abc029;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("dog");
		ProblemA.main(null);
		assertResultIs("dogs");
	}

	@Test
	void case2() {
		in.input("chokudai");
		ProblemA.main(null);
		assertResultIs("chokudais");
	}
}
