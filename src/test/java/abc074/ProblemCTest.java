package abc074;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1 2 10 20 15 200");
		ProblemC.main(null);
		assertResultIs("110 10");
	}

	@Test
	void case2() {
		in.input("1 2 1 2 100 1000");
		ProblemC.main(null);
		assertResultIs("800 400");
	}

	@Test
	void case3() {
		in.input("17 19 22 26 55 2802");
		ProblemC.main(null);
		assertResultIs("2634 934");
	}
}
