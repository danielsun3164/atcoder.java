package abc050;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("1422");
		ProblemD.main(null);
		assertResultIs("52277");
	}

	@Test
	void case3() {
		in.input("1000000000000000000");
		ProblemD.main(null);
		assertResultIs("787014179");
	}
}
