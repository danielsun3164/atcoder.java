package abc094;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "2 4 4 3");
		ProblemC.main(null);
		assertResultIs("4" + LF + "3" + LF + "3" + LF + "4");
	}

	@Test
	void case2() {
		in.input("2\n" + "1 2");
		ProblemC.main(null);
		assertResultIs("2" + LF + "1");
	}

	@Test
	void case3() {
		in.input("6\n" + "5 5 4 4 3 3");
		ProblemC.main(null);
		assertResultIs("4" + LF + "4" + LF + "4" + LF + "4" + LF + "4" + LF + "4");
	}
}
