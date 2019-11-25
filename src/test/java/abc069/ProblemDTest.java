package abc069;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("2 2\n" + "3\n" + "2 1 1");
		ProblemD.main(null);
		assertResultIs("1 1" + LF + "3 2");
	}

	@Test
	void case2() {
		in.input("3 5\n" + "5\n" + "1 2 3 4 5");
		ProblemD.main(null);
		assertResultIs("1 2 2 3 3" + LF + "4 4 4 4 3" + LF + "5 5 5 5 5");
	}

	@Test
	void case3() {
		in.input("1 1\n" + "1\n" + "1");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void case4() {
		in.input("3 5\n" + "5\n" + "1 1 1 1 11");
		ProblemD.main(null);
		assertResultIs("1 2 3 4 5" + LF + "5 5 5 5 5" + LF + "5 5 5 5 5");
	}
}
