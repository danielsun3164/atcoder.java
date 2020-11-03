package abc.abc072;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "3 1 4 1 5 9 2", "4");
	}

	@Test
	void case2() {
		check("10\n" + "0 1 2 3 4 5 6 7 8 9", "3");
	}

	@Test
	void case3() {
		check("1\n" + "99999", "1");
	}
}
