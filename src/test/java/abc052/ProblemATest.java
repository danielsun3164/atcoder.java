package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 5 2 7");
		ProblemA.main(null);
		assertResultIs("15");
	}

	@Test
	void test_Case2() {
		in.input("100 600 200 300");
		ProblemA.main(null);
		assertResultIs("60000");
	}
}
