package abc022;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("5 7\n" + "1 2 2\n" + "1 4 1\n" + "2 3 7\n" + "1 5 12\n" + "3 5 2\n" + "2 5 3\n" + "3 4 5");
		ProblemC.main(null);
		assertResultIs("13");
	}

	@Test
	void case2() {
		in.input("5 4\n" + "1 2 1\n" + "1 3 1\n" + "1 4 1\n" + "1 5 1");
		ProblemC.main(null);
		assertResultIs("-1");
	}

	@Test
	void case3() {
		in.input("10 12\n" + "1 4 3\n" + "1 9 1\n" + "2 5 4\n" + "2 6 1\n" + "3 7 5\n" + "3 10 9\n" + "4 7 2\n"
				+ "5 6 6\n" + "5 8 5\n" + "6 8 3\n" + "7 9 5\n" + "8 10 8");
		ProblemC.main(null);
		assertResultIs("11");
	}
}
