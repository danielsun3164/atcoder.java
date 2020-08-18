package abc175;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("6 2 4");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("7 4 3");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("10 1 2");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case4() {
		in.input("1000000000000000 1000000000000000 1000000000000000");
		ProblemC.main(null);
		assertResultIs("1000000000000000");
	}
}
