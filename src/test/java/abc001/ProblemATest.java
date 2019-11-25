package abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("15\n" + "10");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("0\n" + "0");
		ProblemA.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("5\n" + "20");
		ProblemA.main(null);
		assertResultIs("-15");
	}
}
