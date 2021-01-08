package abc.abc051_100.abc070;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "2\n" + "3", "6");
	}

	@Test
	void case2() {
		check("5\n" + "2\n" + "5\n" + "10\n" + "1000000000000000000\n" + "1000000000000000000", "1000000000000000000");
	}
}
