package abc.abc101_150.abc139;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 3\n" + "1 3\n" + "1 2", "3");
	}

	@Test
	void case2() {
		check("4\n" + "2 3 4\n" + "1 3 4\n" + "4 1 2\n" + "3 1 2", "4");
	}

	@Test
	void case3() {
		check("3\n" + "2 3\n" + "3 1\n" + "1 2", "-1");
	}
}
