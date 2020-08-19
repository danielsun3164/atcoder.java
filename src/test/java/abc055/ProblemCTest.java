package abc055;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 6", "2");
	}

	@Test
	void case2() {
		check("12345 678901", "175897");
	}
}
