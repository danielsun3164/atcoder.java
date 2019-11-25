package abc060;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4 6\n" + "2 1\n" + "3 4\n" + "4 10\n" + "3 4");
		ProblemD.main(null);
		assertResultIs("11");
	}

	@Test
	void case2() {
		in.input("4 6\n" + "2 1\n" + "3 7\n" + "4 10\n" + "3 6");
		ProblemD.main(null);
		assertResultIs("13");
	}

	@Test
	void case3() {
		in.input("4 10\n" + "1 100\n" + "1 100\n" + "1 100\n" + "1 100");
		ProblemD.main(null);
		assertResultIs("400");
	}

	@Test
	void case4() {
		in.input("4 1\n" + "10 100\n" + "10 100\n" + "10 100\n" + "10 100");
		ProblemD.main(null);
		assertResultIs("0");
	}
}
