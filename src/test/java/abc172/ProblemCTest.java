package abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 4 240\n" + "60 90 120\n" + "80 150 80 150");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("3 4 730\n" + "60 90 120\n" + "80 150 80 150");
		ProblemC.main(null);
		assertResultIs("7");
	}

	@Test
	void case3() {
		in.input("5 4 1\n" + "1000000000 1000000000 1000000000 1000000000 1000000000\n"
				+ "1000000000 1000000000 1000000000 1000000000");
		ProblemC.main(null);
		assertResultIs("0");
	}
}
