package abc.abc151_200.abc152;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("25", "17");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@Test
	void case3() {
		check("100", "108");
	}

	@Test
	void case4() {
		check("2020", "40812");
	}

	@Test
	void case5() {
		check("200000", "400000008");
	}
}
