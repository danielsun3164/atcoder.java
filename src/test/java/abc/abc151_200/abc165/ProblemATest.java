package abc.abc151_200.abc165;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "500 600", "OK");
	}

	@Test
	void case2() {
		check("4\n" + "5 7", "NG");
	}

	@Test
	void case3() {
		check("1\n" + "11 11", "OK");
	}
}
