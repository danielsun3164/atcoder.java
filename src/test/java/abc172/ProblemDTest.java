package abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4");
		ProblemD.main(null);
		assertResultIs("23");
	}

	@Test
	void case2() {
		in.input("100");
		ProblemD.main(null);
		assertResultIs("26879");
	}

	@Test
	void case3() {
		in.input("10000000");
		ProblemD.main(null);
		assertResultIs("838627288460105");
	}
}
