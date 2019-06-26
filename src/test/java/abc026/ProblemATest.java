package abc026;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("10");
		ProblemA.main(null);
		assertResultIs("25");
	}

	@Test
	void test_Case2() {
		in.input("60");
		ProblemA.main(null);
		assertResultIs("900");
	}
}
