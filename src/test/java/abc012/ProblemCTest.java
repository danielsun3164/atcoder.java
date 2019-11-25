package abc012;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("2013");
		ProblemC.main(null);
		assertResultIs("2 x 6" + LF + "3 x 4" + LF + "4 x 3" + LF + "6 x 2");
	}

	@Test
	void case2() {
		in.input("2024");
		ProblemC.main(null);
		assertResultIs("1 x 1");
	}
}
