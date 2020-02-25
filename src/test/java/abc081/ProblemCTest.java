package abc081;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("5 2\n" + "1 1 2 2 5");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("4 4\n" + "1 1 2 2");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("10 3\n" + "5 1 3 2 4 1 1 2 3 4");
		ProblemC.main(null);
		assertResultIs("3");
	}
}
