package abc170;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "24 11 8 3 16");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("4\n" + "5 5 5 5");
		ProblemD.main(null);
		assertResultIn("0");
	}

	@Test
	void case3() {
		in.input("10\n" + "33 18 45 28 8 19 89 86 2 4");
		ProblemD.main(null);
		assertResultIn("5");
	}
}
