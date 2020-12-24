package abc.abc001_050.abc038;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2 3 2 1", "8");
	}

	@Test
	void case2() {
		check("4\n" + "1 2 3 4", "10");
	}

	@Test
	void case3() {
		check("6\n" + "3 3 4 1 2 2", "8");
	}

	@Test
	void case4() {
		check("6\n" + "1 5 2 3 4 2", "10");
	}
}
