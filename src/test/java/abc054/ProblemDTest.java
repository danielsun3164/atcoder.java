package abc054;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 1 1\n" + "1 2 1\n" + "2 1 2\n" + "3 3 10");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("1 1 10\n" + "10 10 10");
		ProblemD.main(null);
		assertResultIs("-1");
	}
}
