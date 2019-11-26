package abc072;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("7\n" + "3 1 4 1 5 9 2");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("10\n" + "0 1 2 3 4 5 6 7 8 9");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("1\n" + "99999");
		ProblemC.main(null);
		assertResultIs("1");
	}
}
