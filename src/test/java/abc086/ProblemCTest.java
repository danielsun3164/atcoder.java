package abc086;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "3 1 2\n" + "6 1 1");
		ProblemC.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("1\n" + "2 100 100");
		ProblemC.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("2\n" + "5 1 1\n" + "100 1 1");
		ProblemC.main(null);
		assertResultIs("No");
	}
}
