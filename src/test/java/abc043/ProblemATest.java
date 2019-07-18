package abc043;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3");
		ProblemA.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case2() {
		in.input("10");
		ProblemA.main(null);
		assertResultIs("55");
	}

	@Test
	void test_Case3() {
		in.input("1");
		ProblemA.main(null);
		assertResultIs("1");
	}
}
