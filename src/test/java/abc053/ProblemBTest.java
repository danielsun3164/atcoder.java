package abc053;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("QWERTYASDFZXCV");
		ProblemB.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case2() {
		in.input("ZABCZ");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case3() {
		in.input("HASFJGHOGAKZZFEGA");
		ProblemB.main(null);
		assertResultIs("12");
	}
}
