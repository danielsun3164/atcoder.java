package abc.abc013;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "6", "2");
	}

	@Test
	void case2() {
		check("6\n" + "4", "2");
	}

	@Test
	void case3() {
		check("8\n" + "1", "3");
	}
}
