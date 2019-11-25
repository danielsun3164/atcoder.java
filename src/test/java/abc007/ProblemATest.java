package abc007;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("4");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("100");
		ProblemA.main(null);
		assertResultIs("99");
	}

	@Test
	void case3() {
		in.input("1");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
