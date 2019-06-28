package abc029;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("12");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case2() {
		in.input("345");
		ProblemD.main(null);
		assertResultIs("175");
	}

	@Test
	void test_Case3() {
		in.input("999999999");
		ProblemD.main(null);
		assertResultIs("900000000");
	}
}
