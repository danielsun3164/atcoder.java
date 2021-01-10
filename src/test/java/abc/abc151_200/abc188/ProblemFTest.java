package abc.abc151_200.abc188;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 9", "3");
	}

	@Test
	void case2() {
		check("7 11", "3");
	}

	@Test
	void case3() {
		check("1000000000000000000 1000000000000000000", "0");
	}
}
