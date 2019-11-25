package abc012;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "1 2 10\n" + "2 3 10");
		ProblemD.main(null);
		assertResultIs("10");
	}

	@Test
	void case2() {
		in.input("5 5\n" + "1 2 12\n" + "2 3 14\n" + "3 4 7\n" + "4 5 9\n" + "5 1 18");
		ProblemD.main(null);
		assertResultIs("26");
	}

	@Test
	void case3() {
		in.input("4 6\n" + "1 2 1\n" + "2 3 1\n" + "3 4 1\n" + "4 1 1\n" + "1 3 1\n" + "4 2 1");
		ProblemD.main(null);
		assertResultIs("1");
	}
}
