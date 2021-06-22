package abc.abc201_250.abc205;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 2 4", ">");
	}

	@Test
	void case2() {
		check("-7 7 2", "=");
	}

	@Test
	void case3() {
		check("-8 6 3", "<");
	}
}
