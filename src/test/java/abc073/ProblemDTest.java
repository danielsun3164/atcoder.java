package abc073;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 3 3\n" + "1 2 3\n" + "1 2 1\n" + "2 3 1\n" + "3 1 4");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("3 3 2\n" + "1 3\n" + "2 3 2\n" + "1 3 6\n" + "1 2 2");
		ProblemD.main(null);
		assertResultIs("4");
	}

	@Test
	void case3() {
		in.input("4 6 3\n" + "2 3 4\n" + "1 2 4\n" + "2 3 3\n" + "4 3 1\n" + "1 4 1\n" + "4 2 2\n" + "3 1 6");
		ProblemD.main(null);
		assertResultIs("3");
	}
}
