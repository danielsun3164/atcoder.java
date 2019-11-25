package abc057;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("9 12");
		ProblemA.main(null);
		assertResultIs("21");
	}

	@Test
	void case2() {
		in.input("19 0");
		ProblemA.main(null);
		assertResultIs("19");
	}

	@Test
	void case3() {
		in.input("23 2");
		ProblemA.main(null);
		assertResultIs("1");
	}
}
