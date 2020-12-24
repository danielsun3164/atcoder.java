package abc.abc101_150.abc130;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 6\n" + "3 4 5", "2");
	}

	@Test
	void case2() {
		check("4 9\n" + "3 3 3 3", "4");
	}
}
