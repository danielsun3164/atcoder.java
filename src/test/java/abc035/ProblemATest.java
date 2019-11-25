package abc035;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("4 3");
		ProblemA.main(null);
		assertResultIs("4:3");
	}

	@Test
	void case2() {
		in.input("16 9");
		ProblemA.main(null);
		assertResultIs("16:9");
	}

	@Test
	void case3() {
		in.input("28 21");
		ProblemA.main(null);
		assertResultIs("4:3");
	}
}
