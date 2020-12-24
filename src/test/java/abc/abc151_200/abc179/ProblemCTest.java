package abc.abc151_200.abc179;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3", "3");
	}

	@Test
	void case2() {
		check("100", "473");
	}

	@Test
	void case3() {
		check("1000000", "13969985");
	}
}
