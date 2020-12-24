package abc.abc051_100.abc053;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("QWERTYASDFZXCV", "5");
	}

	@Test
	void case2() {
		check("ZABCZ", "4");
	}

	@Test
	void case3() {
		check("HASFJGHOGAKZZFEGA", "12");
	}
}
