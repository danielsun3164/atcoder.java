package abc.abc101_150.abc112;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 3 5\n" + "2 1 5\n" + "1 2 5\n" + "3 2 5", "2 2 6");
	}

	@Test
	void case2() {
		check("2\n" + "0 0 100\n" + "1 1 98", "0 0 100");
	}

	@Test
	void case3() {
		check("3\n" + "99 1 191\n" + "100 1 192\n" + "99 0 192", "100 0 193");
	}
}
