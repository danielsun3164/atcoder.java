package abc011;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("taKahAshI");
		ProblemB.main(null);
		assertResultIs("Takahashi");
	}

	@Test
	void test_Case2() {
		in.input("A");
		ProblemB.main(null);
		assertResultIs("A");
	}
}
