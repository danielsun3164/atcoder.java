package abc074;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "4");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("19\n" + "100");
		ProblemA.main(null);
		assertResultIs("261");
	}

	@Test
	void case3() {
		in.input("10\n" + "0");
		ProblemA.main(null);
		assertResultIs("100");
	}
}
