package abc083;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("010");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("100000000");
		ProblemD.main(null);
		assertResultIs("8");
	}

	@Test
	void case3() {
		in.input("00001111");
		ProblemD.main(null);
		assertResultIs("4");
	}

	@Test
	void case4() {
		in.input("00000");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void case5() {
		in.input("111111");
		ProblemD.main(null);
		assertResultIs("6");
	}
}
