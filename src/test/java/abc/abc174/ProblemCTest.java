package abc.abc174;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("101", "4");
	}

	@Test
	void case2() {
		check("2", "-1");
	}

	@Test
	void case3() {
		check("999983", "999982");
	}
}
