package abc.abc201_250.abc215;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("aab 2", "aba");
	}

	@Test
	void case2() {
		check("baba 4", "baab");
	}

	@Test
	void case3() {
		check("ydxwacbz 40320", "zyxwdcba");
	}
}
