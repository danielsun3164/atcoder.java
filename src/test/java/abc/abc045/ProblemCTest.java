package abc.abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("125", "176");
	}

	@Test
	void case2() {
		check("9999999999", "12656242944");
	}
}
