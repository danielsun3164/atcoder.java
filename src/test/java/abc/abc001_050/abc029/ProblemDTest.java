package abc.abc001_050.abc029;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("12", "5");
	}

	@Test
	void case2() {
		check("345", "175");
	}

	@Test
	void case3() {
		check("999999999", "900000000");
	}
}
