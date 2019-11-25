package abc021;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("10\n" + "2");
		ProblemD.main(null);
		assertResultIs("55");
	}

	@Test
	void case2() {
		in.input("10\n" + "3");
		ProblemD.main(null);
		assertResultIs("220");
	}

	@Test
	void case3() {
		in.input("10\n" + "4");
		ProblemD.main(null);
		assertResultIs("715");
	}

	@Test
	void case4() {
		in.input("400\n" + "296");
		ProblemD.main(null);
		assertResultIs("546898535");
	}

	@Test
	void case5() {
		in.input("100000\n" + "100000");
		ProblemD.main(null);
		assertResultIs("939733670");
	}
}
