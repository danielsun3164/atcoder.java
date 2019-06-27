package abc028;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 2 3 4 5");
		ProblemC.main(null);
		assertResultIs("10");
	}

	@Test
	void test_Case2() {
		in.input("1 2 3 5 8");
		ProblemC.main(null);
		assertResultIs("14");
	}
}
