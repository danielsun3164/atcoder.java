package abc.abc088;

import org.junit.jupiter.api.Test;

import practice.TestBase;

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
