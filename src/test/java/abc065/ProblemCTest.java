package abc065;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2 2");
		ProblemC.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("3 2");
		ProblemC.main(null);
		assertResultIs("12");
	}

	@Test
	void case3() {
		in.input("1 8");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("100000 100000");
		ProblemC.main(null);
		assertResultIs("530123477");
	}
}
