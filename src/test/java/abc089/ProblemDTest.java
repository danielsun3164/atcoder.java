package abc089;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 3 2\n" + "1 4 3\n" + "2 5 7\n" + "8 9 6\n" + "1\n" + "4 8");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("4 2 3\n" + "3 7\n" + "1 4\n" + "5 2\n" + "6 8\n" + "2\n" + "2 2\n" + "2 2");
		ProblemD.main(null);
		assertResultIs("0" + LF + "0");
	}

	@Test
	void case3() {
		in.input("5 5 4\n" + "13 25 7 15 17\n" + "16 22 20 2 9\n" + "14 11 12 1 19\n" + "10 6 23 8 18\n"
				+ "3 21 5 24 4\n" + "3\n" + "13 13\n" + "2 10\n" + "13 13");
		ProblemD.main(null);
		assertResultIs("0" + LF + "5" + LF + "0");
	}
}
