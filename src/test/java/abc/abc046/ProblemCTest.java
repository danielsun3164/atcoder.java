package abc.abc046;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 3\n" + "1 1\n" + "3 2", "10");
	}

	@Test
	void case2() {
		check("4\n" + "1 1\n" + "1 1\n" + "1 5\n" + "1 100", "101");
	}

	@Test
	void case3() {
		check("5\n" + "3 10\n" + "48 17\n" + "31 199\n" + "231 23\n" + "3 2", "6930");
	}
}
