package abc.abc151_200.abc187;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("123 234", "9");
	}

	@Test
	void case2() {
		check("593 953", "17");
	}

	@Test
	void case3() {
		check("100 999", "27");
	}
}
