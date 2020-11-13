package abc.abc129;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 3", "0");
	}

	@Test
	void case2() {
		check("4\n" + "1 3 1 1", "2");
	}

	@Test
	void case3() {
		check("8\n" + "27 23 76 2 3 5 62 52", "2");
	}
}
