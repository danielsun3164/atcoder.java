package abc044;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("abaccaba");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case2() {
		in.input("hthth");
		ProblemB.main(null);
		assertResultIs("No");
	}
}
