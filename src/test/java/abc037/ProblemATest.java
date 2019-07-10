package abc037;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 5 6");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("8 6 20");
		ProblemA.main(null);
		assertResultIs("3");
	}
}
