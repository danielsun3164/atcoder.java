package abc059;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("2 1");
		ProblemD.main(null);
		assertResultIs("Brown");
	}

	@Test
	void case2() {
		in.input("5 0");
		ProblemD.main(null);
		assertResultIs("Alice");
	}

	@Test
	void case3() {
		in.input("0 0");
		ProblemD.main(null);
		assertResultIs("Brown");
	}

	@Test
	void case4() {
		in.input("4 8");
		ProblemD.main(null);
		assertResultIs("Alice");
	}
}
