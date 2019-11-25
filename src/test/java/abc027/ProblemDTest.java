package abc027;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("M+MM-M");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("MMM+M");
		ProblemD.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("MMM+--MMM");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case4() {
		in.input("+");
		ProblemD.main(null);
		assertResultIs("0");
	}
}
