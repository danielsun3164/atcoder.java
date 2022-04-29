package abc.abc151_200.abc161;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("15", "23");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@Test
	void case3() {
		check("13", "21");
	}

	@Test
	void case4() {
		check("100000", "3234566667");
	}
}
