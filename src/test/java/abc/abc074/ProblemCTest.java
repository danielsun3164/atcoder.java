package abc.abc074;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 2 10 20 15 200", "110 10");
	}

	@Test
	void case2() {
		check("1 2 1 2 100 1000", "800 400");
	}

	@Test
	void case3() {
		check("17 19 22 26 55 2802", "2634 934");
	}
}
