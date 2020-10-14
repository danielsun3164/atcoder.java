package abc.abc124;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("000", "1");
	}

	@Test
	void case2() {
		check("10010010", "3");
	}

	@Test
	void case3() {
		check("0", "0");
	}
}
