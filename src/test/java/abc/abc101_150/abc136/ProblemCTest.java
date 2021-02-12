package abc.abc101_150.abc136;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2 1 1 3", "Yes");
	}

	@Test
	void case2() {
		check("4\n" + "1 3 2 1", "No");
	}

	@Test
	void case3() {
		check("5\n" + "1 2 3 4 5", "Yes");
	}

	@Test
	void case4() {
		check("1\n" + "1000000000", "Yes");
	}
}
