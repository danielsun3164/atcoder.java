package abc.abc151_200.abc192;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("314 2", "693");
	}

	@Test
	void case2() {
		check("1000000000 100", "0");
	}

	@Test
	void case3() {
		check("6174 100000", "6174");
	}
}
