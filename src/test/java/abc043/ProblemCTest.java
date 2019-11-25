package abc043;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "4 8");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("3\n" + "1 1 3");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("3\n" + "4 2 5");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case4() {
		in.input("4\n" + "-100 -100 -100 -100");
		ProblemC.main(null);
		assertResultIs("0");
	}
}
