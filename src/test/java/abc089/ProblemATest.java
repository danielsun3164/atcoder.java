package abc089;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("8");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("2");
		ProblemA.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("9");
		ProblemA.main(null);
		assertResultIs("3");
	}
}
