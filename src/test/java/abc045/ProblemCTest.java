package abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("125");
		ProblemC.main(null);
		assertResultIs("176");
	}

	@Test
	void case2() {
		in.input("9999999999");
		ProblemC.main(null);
		assertResultIs("12656242944");
	}
}
