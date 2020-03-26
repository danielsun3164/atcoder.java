package abc092;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "3 5 -1");
		ProblemC.main(null);
		assertResultIs("12" + LF + "8" + LF + "10");
	}

	@Test
	void case2() {
		in.input("5\n" + "1 1 1 2 0");
		ProblemC.main(null);
		assertResultIs("4" + LF + "4" + LF + "4" + LF + "2" + LF + "4");
	}

	@Test
	void case3() {
		in.input("6\n" + "-679 -2409 -3258 3095 -3291 -4462");
		ProblemC.main(null);
		assertResultIs("21630" + LF + "21630" + LF + "19932" + LF + "8924" + LF + "21630" + LF + "19288");
	}
}
