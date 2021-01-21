package abc.abc101_150.abc134;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 0 0", "1" + LF + "1");
	}

	@Test
	void case2() {
		check("5\n" + "0 0 0 0 0", "0");
	}
}
