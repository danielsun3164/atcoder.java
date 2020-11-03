package abc.abc168;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("16", "pon");
	}

	@Test
	void case2() {
		check("2", "hon");
	}

	@Test
	void case3() {
		check("183", "bon");
	}
}
