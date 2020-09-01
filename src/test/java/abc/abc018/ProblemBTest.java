package abc.abc018;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abcdef\n" + "2\n" + "3 5\n" + "1 4", "debacf");
	}

	@Test
	void case2() {
		check("redcoat\n" + "3\n" + "1 7\n" + "1 2\n" + "3 4", "atcoder");
	}
}
