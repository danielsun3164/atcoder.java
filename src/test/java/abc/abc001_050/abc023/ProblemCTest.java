package abc.abc001_050.abc023;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 5 3\n" + "5\n" + "1 2\n" + "2 1\n" + "2 5\n" + "3 2\n" + "3 5", "5");
	}

	@Test
	void case2() {
		check("7 3 1\n" + "4\n" + "3 2\n" + "3 3\n" + "4 2\n" + "4 3", "0");
	}

	@Test
	void case3() {
		check("5 5 2\n" + "5\n" + "1 1\n" + "2 2\n" + "3 3\n" + "4 4\n" + "5 5", "20");
	}
}
