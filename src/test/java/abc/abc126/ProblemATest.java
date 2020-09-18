package abc.abc126;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
