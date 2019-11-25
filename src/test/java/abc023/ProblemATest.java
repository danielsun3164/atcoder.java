package abc023;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("23");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("70");
		ProblemA.main(null);
		assertResultIs("7");
	}

	@Test
	void case3() {
		in.input("99");
		ProblemA.main(null);
		assertResultIs("18");
	}
}
