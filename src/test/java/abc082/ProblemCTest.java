package abc082;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "3 3 3 3");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("5\n" + "2 4 1 4 2");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("6\n" + "1 2 2 3 3 3");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("1\n" + "1000000000");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case5() {
		in.input("8\n" + "2 7 1 8 2 8 1 8");
		ProblemC.main(null);
		assertResultIs("5");
	}
}
