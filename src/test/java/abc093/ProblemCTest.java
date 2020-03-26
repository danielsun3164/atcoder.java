package abc093;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2 5 4");
		ProblemC.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("2 6 3");
		ProblemC.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("31 41 5");
		ProblemC.main(null);
		assertResultIs("23");
	}
}
