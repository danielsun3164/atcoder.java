package abc069;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("internationalization");
		ProblemB.main(null);
		assertResultIs("i18n");
	}

	@Test
	void test_Case2() {
		in.input("smiles");
		ProblemB.main(null);
		assertResultIs("s4s");
	}

	@Test
	void test_Case3() {
		in.input("xyz");
		ProblemB.main(null);
		assertResultIs("x1z");
	}
}
