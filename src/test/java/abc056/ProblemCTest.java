package abc056;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("6");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("2");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("11");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case4() {
		in.input("10");
		ProblemC.main(null);
		assertResultIs("4");
	}
}
