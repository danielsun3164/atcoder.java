package abc.abc151_200.abc167;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("chokudai\n" + "chokudaiz", "Yes");
	}

	@Test
	void case2() {
		check("snuke\n" + "snekee", "No");
	}

	@Test
	void case3() {
		check("a\n" + "aa", "Yes");
	}
}
