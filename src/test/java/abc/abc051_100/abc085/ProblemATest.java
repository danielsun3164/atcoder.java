package abc.abc051_100.abc085;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2017/01/07", "2018/01/07");
	}

	@Test
	void case2() {
		check("2017/01/31", "2018/01/31");
	}

	@Test
	void case3() {
		check("2017/01/01", "2018/01/01");
	}
}
