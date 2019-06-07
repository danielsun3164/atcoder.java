package abc011;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("12");
		ProblemA.main(null);
		assertResultIs("1");
	}
}
