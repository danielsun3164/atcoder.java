package abc066;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "1 2 3 4");
		ProblemC.main(null);
		assertResultIs("4 2 1 3");
	}

	@Test
	void case2() {
		in.input("3\n" + "1 2 3");
		ProblemC.main(null);
		assertResultIs("3 1 2");
	}

	@Test
	void case3() {
		in.input("1\n" + "1000000000");
		ProblemC.main(null);
		assertResultIs("1000000000");
	}

	@Test
	void case4() {
		in.input("6\n" + "0 6 7 6 7 0");
		ProblemC.main(null);
		assertResultIs("0 6 6 0 7 7");
	}
}
