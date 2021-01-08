package abc.abc001_050.abc050;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 4 4 0 2", "4");
	}

	@Test
	void case2() {
		check("7\n" + "6 4 0 2 4 0 2", "0");
	}

	@Test
	void case3() {
		check("8\n" + "7 5 1 1 7 3 5 3", "16");
	}
}
