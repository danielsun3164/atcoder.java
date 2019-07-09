package abc036;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("12 36");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("12 100");
		ProblemA.main(null);
		assertResultIs("9");
	}
}
