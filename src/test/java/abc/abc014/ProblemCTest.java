package abc.abc014;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 2\n" + "2 3\n" + "2 4\n" + "5 6", "3");
	}

	@Test
	void case2() {
		check("4\n" + "1000000 1000000\n" + "1000000 1000000\n" + "0 1000000\n" + "1 1000000", "4");
	}
}
