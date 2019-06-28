package abc029;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("dog");
		ProblemA.main(null);
		assertResultIs("dogs");
	}

	@Test
	void test_Case2() {
		in.input("chokudai");
		ProblemA.main(null);
		assertResultIs("chokudais");
	}
}
