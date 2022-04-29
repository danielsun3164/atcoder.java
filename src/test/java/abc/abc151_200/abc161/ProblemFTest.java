package abc.abc151_200.abc161;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("6", "3");
	}

	@Test
	void case2() {
		check("3141", "13");
	}

	@Test
	void case3() {
		check("314159265358", "9");
	}

	@Test
	void case4() {
		check("2", "1");
	}
}
