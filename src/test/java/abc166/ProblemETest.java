package abc166;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("6\n" + "2 3 3 1 3 1");
		ProblemE.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("6\n" + "5 2 4 2 8 8");
		ProblemE.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("32\n" + "3 1 4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4 6 2 6 4 3 3 8 3 2 7 9 5");
		ProblemE.main(null);
		assertResultIs("22");
	}
}
