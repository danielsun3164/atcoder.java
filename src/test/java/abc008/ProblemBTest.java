package abc008;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "taro\n" + "jiro\n" + "taro\n" + "saburo", "taro");
	}

	@Test
	void case2() {
		check("1\n" + "takahashikun", "takahashikun");
	}

	@Test
	void case3() {
		checkResultMatches("9\n" + "a\n" + "b\n" + "c\n" + "c\n" + "b\n" + "c\n" + "b\n" + "d\n" + "e", "(b|c)");
	}
}
