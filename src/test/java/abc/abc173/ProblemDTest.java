package abc.abc173;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 2 1 3", "7");
	}

	@Test
	void case2() {
		check("7\n" + "1 1 1 1 1 1 1", "6");
	}
}
