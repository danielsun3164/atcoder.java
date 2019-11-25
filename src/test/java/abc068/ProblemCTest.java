package abc068;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "1 2\n" + "2 3");
		ProblemC.main(null);
		assertResultIs("POSSIBLE");
	}

	@Test
	void case2() {
		in.input("4 3\n" + "1 2\n" + "2 3\n" + "3 4");
		ProblemC.main(null);
		assertResultIs("IMPOSSIBLE");
	}

	@Test
	void case3() {
		in.input("100000 1\n" + "1 99999");
		ProblemC.main(null);
		assertResultIs("IMPOSSIBLE");
	}

	@Test
	void case4() {
		in.input("5 5\n" + "1 3\n" + "4 5\n" + "2 3\n" + "2 4\n" + "1 4");
		ProblemC.main(null);
		assertResultIs("POSSIBLE");
	}
}
