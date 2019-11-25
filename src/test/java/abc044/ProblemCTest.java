package abc044;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4 8\n" + "7 9 8 9");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("3 8\n" + "6 6 9");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("8 5\n" + "3 6 2 8 7 6 5 9");
		ProblemC.main(null);
		assertResultIs("19");
	}

	@Test
	void case4() {
		in.input("33 3\n" + "3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3");
		ProblemC.main(null);
		assertResultIs("8589934591");
	}
}
