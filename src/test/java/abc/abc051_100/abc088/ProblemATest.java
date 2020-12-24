package abc.abc051_100.abc088;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2018\n" + "218", "Yes");
	}

	@Test
	void case2() {
		check("2763\n" + "0", "No");
	}

	@Test
	void case3() {
		check("37\n" + "514", "Yes");
	}
}
