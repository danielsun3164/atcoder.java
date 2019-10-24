package abc066;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("700 600 780");
		ProblemA.main(null);
		assertResultIs("1300");
	}

	@Test
	void test_Case2() {
		in.input("10000 10000 10000");
		ProblemA.main(null);
		assertResultIs("20000");
	}
}
