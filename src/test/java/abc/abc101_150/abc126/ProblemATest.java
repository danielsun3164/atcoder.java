package abc.abc101_150.abc126;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "ABC", "aBC");
	}

	@Test
	void case2() {
		check("4 3\n" + "CABA", "CAbA");
	}
}
