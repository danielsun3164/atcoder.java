package abc173;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "2 2 1 3");
		ProblemD.main(null);
		assertResultIs("7");
	}

	@Test
	void case2() {
		in.input("7\n" + "1 1 1 1 1 1 1");
		ProblemD.main(null);
		assertResultIs("6");
	}
}
