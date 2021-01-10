package abc.abc151_200.abc188;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 4 2 5", "2");
	}

	@Test
	void case2() {
		check("2\n" + "3 1 5 4", "1");
	}

	@Test
	void case3() {
		check("4\n" + "6 13 12 5 3 7 10 11 16 9 8 15 2 1 14 4", "2");
	}
}
