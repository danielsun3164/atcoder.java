package abc.abc051;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2 1\n" + "1 3 1\n" + "2 3 3", "1");
	}

	@Test
	void case2() {
		check("3 2\n" + "1 2 1\n" + "2 3 1", "0");
	}
}
