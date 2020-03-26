package abc093;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 8 2");
		ProblemB.main(null);
		assertResultIs("3" + LF + "4" + LF + "7" + LF + "8");
	}

	@Test
	void case2() {
		in.input("4 8 3");
		ProblemB.main(null);
		assertResultIs("4" + LF + "5" + LF + "6" + LF + "7" + LF + "8");
	}

	@Test
	void case3() {
		in.input("2 9 100");
		ProblemB.main(null);
		assertResultIs("2" + LF + "3" + LF + "4" + LF + "5" + LF + "6" + LF + "7" + LF + "8" + LF + "9");
	}
}
