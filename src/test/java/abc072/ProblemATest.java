package abc072;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("100 17");
		ProblemA.main(null);
		assertResultIs("83");
	}

	@Test
	void case2() {
		in.input("48 58");
		ProblemA.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("1000000000 1000000000");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
