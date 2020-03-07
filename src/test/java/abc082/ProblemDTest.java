package abc082;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("FTFFTFFF\n" + "4 2");
		ProblemD.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("FTFFTFFF\n" + "-2 -2");
		ProblemD.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case3() {
		in.input("FF\n" + "1 0");
		ProblemD.main(null);
		assertResultIs("No");
	}

	@Test
	void case4() {
		in.input("TF\n" + "1 0");
		ProblemD.main(null);
		assertResultIs("No");
	}

	@Test
	void case5() {
		in.input("FFTTFF\n" + "0 0");
		ProblemD.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case6() {
		in.input("TTTT\n" + "1 0");
		ProblemD.main(null);
		assertResultIs("No");
	}
}
