package abc090;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2 2");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case2() {
		in.input("1 7");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("314 1592");
		ProblemC.main(null);
		assertResultIs("496080");
	}
}
