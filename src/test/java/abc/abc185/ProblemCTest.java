package abc.abc185;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("12", "1");
	}

	@Test
	void case2() {
		check("13", "12");
	}

	@Test
	void case3() {
		check("17", "4368");
	}
}
