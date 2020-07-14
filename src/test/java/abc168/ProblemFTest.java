package abc168;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("5 6\n" + "1 2 0\n" + "0 1 1\n" + "0 2 2\n" + "-3 4 -1\n" + "-2 6 3\n" + "1 0 1\n" + "0 1 2\n"
				+ "2 0 2\n" + "-1 -4 5\n" + "3 -2 4\n" + "1 2 4");
		ProblemF.main(null);
		assertResultIs("13");
	}

	@Test
	void case2() {
		in.input("6 1\n" + "-3 -1 -2\n" + "-3 -1 1\n" + "-2 -1 2\n" + "1 4 -2\n" + "1 4 -1\n" + "1 4 1\n" + "3 1 4");
		ProblemF.main(null);
		assertResultIs("INF");
	}
}
