package abc069;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "1 10 100");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("4\n" + "1 2 3 4");
		ProblemC.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("3\n" + "1 4 1");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case4() {
		in.input("2\n" + "1 1");
		ProblemC.main(null);
		assertResultIs("No");
	}

	@Test
	void case5() {
		in.input("6\n" + "2 7 1 8 2 8");
		ProblemC.main(null);
		assertResultIs("Yes");
	}
}
