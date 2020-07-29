package abc170;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("6 5\n" + "4 7 10 6 5");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("10 5\n" + "4 7 10 6 5");
		ProblemC.main(null);
		assertResultIs("9");
	}

	@Test
	void case3() {
		in.input("100 0\n" + "");
		ProblemC.main(null);
		assertResultIs("100");
	}
}
