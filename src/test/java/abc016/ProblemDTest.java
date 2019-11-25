package abc016;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("-2 0 2 0\n" + "4\n" + "1 1\n" + "-1 1\n" + "-1 -1\n" + "1 -1");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("-3 1 3 1\n" + "8\n" + "2 2\n" + "1 2\n" + "1 0\n" + "-1 0\n" + "-1 2\n" + "-2 2\n" + "-2 -1\n"
				+ "2 -1");
		ProblemD.main(null);
		assertResultIs("3");
	}
}
