package abc.abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("198 1.10", "217");
	}

	@Test
	void case2() {
		check("1 0.01", "0");
	}

	@Test
	void case3() {
		check("1000000000000000 9.99", "9990000000000000");
	}
}
