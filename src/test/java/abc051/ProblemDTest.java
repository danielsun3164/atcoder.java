package abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 3\n" + "1 2 1\n" + "1 3 1\n" + "2 3 3");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("3 2\n" + "1 2 1\n" + "2 3 1");
		ProblemD.main(null);
		assertResultIs("0");
	}
}
