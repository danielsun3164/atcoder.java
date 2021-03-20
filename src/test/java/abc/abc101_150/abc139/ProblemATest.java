package abc.abc101_150.abc139;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("CSS\n" + "CSR", "2");
	}

	@Test
	void case2() {
		check("SSR\n" + "SSR", "3");
	}

	@Test
	void case3() {
		check("RRR\n" + "SSS", "0");
	}
}
