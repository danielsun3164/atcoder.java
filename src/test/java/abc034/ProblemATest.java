package abc034;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("12 34");
		ProblemA.main(null);
		assertResultIs("Better");
	}

	@Test
	void test_Case2() {
		in.input("98 56");
		ProblemA.main(null);
		assertResultIs("Worse");
	}
}