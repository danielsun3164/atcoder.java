package abc011;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("taKahAshI");
		ProblemB.main(null);
		assertResultIs("Takahashi");
	}

	@Test
	void case2() {
		in.input("A");
		ProblemB.main(null);
		assertResultIs("A");
	}
}
