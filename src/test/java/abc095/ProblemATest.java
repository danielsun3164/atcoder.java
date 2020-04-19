package abc095;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("oxo");
		ProblemA.main(null);
		assertResultIs("900");
	}

	@Test
	void case2() {
		in.input("ooo");
		ProblemA.main(null);
		assertResultIs("1000");
	}

	@Test
	void case3() {
		in.input("xxx");
		ProblemA.main(null);
		assertResultIs("700");
	}
}
