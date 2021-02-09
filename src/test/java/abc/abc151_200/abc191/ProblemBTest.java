package abc.abc151_200.abc191;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 5\n" + "3 5 6 5 4", "3 6 4");
	}

	@Test
	void case2() {
		check("3 3\n" + "3 3 3", "");
	}
}
