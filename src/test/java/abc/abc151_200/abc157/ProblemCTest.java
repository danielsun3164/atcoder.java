package abc.abc151_200.abc157;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 7\n" + "3 2\n" + "1 7", "702");
	}

	@Test
	void case2() {
		check("3 2\n" + "2 1\n" + "2 3", "-1");
	}

	@Test
	void case3() {
		check("3 1\n" + "1 0", "-1");
	}
}
