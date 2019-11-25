package abc023;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 5 3\n" + "5\n" + "1 2\n" + "2 1\n" + "2 5\n" + "3 2\n" + "3 5");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("7 3 1\n" + "4\n" + "3 2\n" + "3 3\n" + "4 2\n" + "4 3");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("5 5 2\n" + "5\n" + "1 1\n" + "2 2\n" + "3 3\n" + "4 4\n" + "5 5");
		ProblemC.main(null);
		assertResultIs("20");
	}
}
