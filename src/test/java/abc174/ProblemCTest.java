package abc174;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("101");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("2");
		ProblemC.main(null);
		assertResultIs("-1");
	}

	@Test
	void case3() {
		in.input("999983");
		ProblemC.main(null);
		assertResultIs("999982");
	}
}
