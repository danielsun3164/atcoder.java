package abc.abc151_200.abc194;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "8 5\n" + "4 4\n" + "7 9", "5");
	}

	@Test
	void case2() {
		check("3\n" + "11 7\n" + "3 2\n" + "6 7", "5");
	}
}
