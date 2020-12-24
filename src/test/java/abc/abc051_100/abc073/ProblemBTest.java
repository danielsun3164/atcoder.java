package abc.abc051_100.abc073;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "24 30", "7");
	}

	@Test
	void case2() {
		check("2\n" + "6 8\n" + "3 3", "4");
	}
}
