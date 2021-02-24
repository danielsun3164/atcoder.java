package abc.abc151_200.abc192;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 9999999999\n" + "3 6 8", "4999999994");
	}

	@Test
	void case2() {
		check("1 1000000000000000000\n" + "1", "999999999999999999");
	}
}
