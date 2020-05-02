package abc096;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("5 5");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("2 1");
		ProblemA.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("11 30");
		ProblemA.main(null);
		assertResultIs("11");
	}
}
