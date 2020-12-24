package abc.abc101_150.abc114;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("575", "4");
	}

	@Test
	void case2() {
		check("3600", "13");
	}

	@Test
	void case3() {
		check("999999999", "26484");
	}
}
