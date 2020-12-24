package abc.abc101_150.abc132;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 3 5 4 2", "2");
	}

	@Test
	void case2() {
		check("9\n" + "9 6 3 2 5 8 7 4 1", "5");
	}
}
