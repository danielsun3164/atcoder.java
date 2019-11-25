package abc062;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 5");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case2() {
		in.input("4 5");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("5 5");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void case4() {
		in.input("100000 2");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case5() {
		in.input("100000 100000");
		ProblemC.main(null);
		assertResultIs("50000");
	}
}
