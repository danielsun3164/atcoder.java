package abc.abc101_150.abc127;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "1 3\n" + "2 4", "2");
	}

	@Test
	void case2() {
		check("10 3\n" + "3 6\n" + "5 7\n" + "6 9", "1");
	}

	@Test
	void case3() {
		check("100000 1\n" + "1 100000", "100000");
	}
}
