package abc.abc051_100.abc079;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1222", "1+2+2+2=7");
	}

	@Test
	void case2() {
		checkResultIn("0290", "0-2+9+0=7", "0-2+9-0=7");
	}

	@Test
	void case3() {
		checkResultIn("3242", "3+2+4-2=7", "3-2+4+2=7");
	}
}
