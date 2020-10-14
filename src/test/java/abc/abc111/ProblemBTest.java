package abc.abc111;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("111", "111");
	}

	@Test
	void case2() {
		check("112", "222");
	}

	@Test
	void case3() {
		check("750", "777");
	}
}
