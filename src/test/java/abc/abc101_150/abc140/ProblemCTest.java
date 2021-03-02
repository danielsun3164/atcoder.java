package abc.abc101_150.abc140;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 5", "9");
	}

	@Test
	void case2() {
		check("2\n" + "3", "6");
	}

	@Test
	void case3() {
		check("6\n" + "0 153 10 10 23", "53");
	}
}
