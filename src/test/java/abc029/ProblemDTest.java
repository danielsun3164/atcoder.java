package abc029;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("12");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("345");
		ProblemD.main(null);
		assertResultIs("175");
	}

	@Test
	void case3() {
		in.input("999999999");
		ProblemD.main(null);
		assertResultIs("900000000");
	}
}
