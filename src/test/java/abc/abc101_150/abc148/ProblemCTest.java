package abc.abc101_150.abc148;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3", "6");
	}

	@Test
	void case2() {
		check("123 456", "18696");
	}

	@Test
	void case3() {
		check("100000 99999", "9999900000");
	}
}
