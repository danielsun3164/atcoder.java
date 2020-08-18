package abc174;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "WWRR");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("2\n" + "RR");
		ProblemD.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("8\n" + "WRWWRWRR");
		ProblemD.main(null);
		assertResultIs("3");
	}
}
