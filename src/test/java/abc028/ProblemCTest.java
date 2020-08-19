package abc028;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 2 3 4 5", "10");
	}

	@Test
	void case2() {
		check("1 2 3 5 8", "14");
	}
}
