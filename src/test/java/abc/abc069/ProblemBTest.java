package abc.abc069;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("internationalization", "i18n");
	}

	@Test
	void case2() {
		check("smiles", "s4s");
	}

	@Test
	void case3() {
		check("xyz", "x1z");
	}
}
