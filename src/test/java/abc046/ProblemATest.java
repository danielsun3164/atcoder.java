package abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 1 4");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("3 3 33");
		ProblemA.main(null);
		assertResultIs("2");
	}
}
