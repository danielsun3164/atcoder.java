package abc017;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("50 7\n" + "40 8\n" + "30 9");
		ProblemA.main(null);
		assertResultIs("94");
	}

	@Test
	void test_Case2() {
		in.input("990 10\n" + "990 10\n" + "990 10");
		ProblemA.main(null);
		assertResultIs("2970");
	}
}
