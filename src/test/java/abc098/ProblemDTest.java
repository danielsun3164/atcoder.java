package abc098;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "2 5 4 6");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("9\n" + "0 0 0 0 0 0 0 0 0");
		ProblemD.main(null);
		assertResultIs("45");
	}

	@Test
	void case3() {
		in.input("19\n" + "885 8 1 128 83 32 256 206 639 16 4 128 689 32 8 64 885 969 1");
		ProblemD.main(null);
		assertResultIs("37");
	}
}
