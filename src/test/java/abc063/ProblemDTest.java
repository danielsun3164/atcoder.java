package abc063;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4 5 3\n" + "8\n" + "7\n" + "4\n" + "2");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("2 10 4\n" + "20\n" + "20");
		ProblemD.main(null);
		assertResultIs("4");
	}

	@Test
	void case3() {
		in.input("5 2 1\n" + "900000000\n" + "900000000\n" + "1000000000\n" + "1000000000\n" + "1000000000");
		ProblemD.main(null);
		assertResultIs("800000000");
	}
}
