package abc094;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "6 9 4 2 11");
		ProblemD.main(null);
		assertResultIs("11 6");
	}

	@Test
	void case2() {
		in.input("2\n" + "100 0");
		ProblemD.main(null);
		assertResultIs("100 0");
	}
}
