package abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "4\n" + "2", "7");
	}

	@Test
	void case2() {
		check("4\n" + "4\n" + "4", "16");
	}
}
