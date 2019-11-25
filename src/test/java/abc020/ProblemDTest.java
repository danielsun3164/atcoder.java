package abc020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4 2");
		ProblemD.main(null);
		assertResultIs("14");
	}

	@Test
	void case2() {
		in.input("10000 100");
		ProblemD.main(null);
		assertResultIs("865504986");
	}

	@Test
	void case3() {
		in.input("1000000000 90");
		ProblemD.main(null);
		assertResultIs("50001213");
	}

	@Test
	void case4() {
		in.input("1000000000 999999900");
		ProblemD.main(null);
		assertResultIs("231285006");
	}
}
