package abc.abc151_200.abc158;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "25");
	}

	@Test
	void case2() {
		check("8 10", "100");
	}

	@Test
	void case3() {
		check("19 99", "-1");
	}
}
