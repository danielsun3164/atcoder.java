package abc.abc001_050.abc044;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abaccaba", "Yes");
	}

	@Test
	void case2() {
		check("hthth", "No");
	}
}
