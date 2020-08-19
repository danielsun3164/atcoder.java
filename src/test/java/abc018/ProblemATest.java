package abc018;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("12\n" + "18\n" + "11", "2" + LF + "1" + LF + "3");
	}

	@Test
	void case2() {
		check("10\n" + "20\n" + "30", "3" + LF + "2" + LF + "1");
	}
}
