package abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "1 2 3 2 1");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("4\n" + "1 2 3 4");
		ProblemC.main(null);
		assertResultIs("10");
	}

	@Test
	void case3() {
		in.input("6\n" + "3 3 4 1 2 2");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case4() {
		in.input("6\n" + "1 5 2 3 4 2");
		ProblemC.main(null);
		assertResultIs("10");
	}
}
