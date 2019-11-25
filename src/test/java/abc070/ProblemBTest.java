package abc070;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("0 75 25 100");
		ProblemB.main(null);
		assertResultIs("50");
	}

	@Test
	void case2() {
		in.input("0 33 66 99");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("10 90 20 80");
		ProblemB.main(null);
		assertResultIs("60");
	}
}
