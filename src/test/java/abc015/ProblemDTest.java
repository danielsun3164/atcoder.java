package abc015;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("10\n" + "3 2\n" + "4 20\n" + "3 40\n" + "6 100");
		ProblemD.main(null);
		assertResultIs("140");
	}

	@Test
	void case2() {
		in.input("10\n" + "5 4\n" + "9 10\n" + "3 7\n" + "3 1\n" + "2 6\n" + "4 5");
		ProblemD.main(null);
		assertResultIs("18");
	}

	@Test
	void case3() {
		in.input("22\n" + "5 3\n" + "5 40\n" + "8 50\n" + "3 60\n" + "4 70\n" + "6 80");
		ProblemD.main(null);
		assertResultIs("210");
	}
}
