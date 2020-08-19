package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX5Test extends TestBase {

	@Test
	void case1() {
		check("1 2", "3");
	}

	@Test
	void case2() {
		check("100 99", "199");
	}
}
