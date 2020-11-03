package abc.abc050;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3", "5");
	}

	@Test
	void case2() {
		check("1422", "52277");
	}

	@Test
	void case3() {
		check("1000000000000000000", "787014179");
	}
}
