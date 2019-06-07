package abc004;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 3 4");
		ProblemD.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case2() {
		in.input("17 2 34");
		ProblemD.main(null);
		assertResultIs("362");
	}

	@Test
	void test_Case3() {
		in.input("267 294 165");
		ProblemD.main(null);
		assertResultIs("88577");
	}
}
