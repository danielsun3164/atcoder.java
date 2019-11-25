package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2222");
		ProblemA.main(null);
		assertResultIs("SAME");
	}

	@Test
	void case2() {
		in.input("1221");
		ProblemA.main(null);
		assertResultIs("DIFFERENT");
	}

	@Test
	void case3() {
		in.input("0000");
		ProblemA.main(null);
		assertResultIs("SAME");
	}
}
