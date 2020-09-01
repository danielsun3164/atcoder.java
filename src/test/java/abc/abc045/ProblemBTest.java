package abc.abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("aca\n" + "accc\n" + "ca", "A");
	}

	@Test
	void case2() {
		check("abcb\n" + "aacb\n" + "bccc", "C");
	}
}
