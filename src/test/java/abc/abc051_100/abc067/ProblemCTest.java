package abc.abc051_100.abc067;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 2 3 4 5 6", "1");
	}

	@Test
	void case2() {
		check("2\n" + "10 -10", "20");
	}
}
