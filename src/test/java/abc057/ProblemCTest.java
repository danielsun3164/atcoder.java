package abc057;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("10000");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("1000003");
		ProblemC.main(null);
		assertResultIs("7");
	}

	@Test
	void case3() {
		in.input("9876543210");
		ProblemC.main(null);
		assertResultIs("6");
	}

	@Test
	void case4() {
		in.input("100000007");
		ProblemC.main(null);
		assertResultIs("9");
	}
}
