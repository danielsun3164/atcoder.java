package abc023;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("23");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case2() {
		in.input("70");
		ProblemA.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case3() {
		in.input("99");
		ProblemA.main(null);
		assertResultIs("18");
	}
}
