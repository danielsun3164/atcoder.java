package abc006;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("7");
		ProblemB.main(null);
		assertResultIs("7");
	}

	@Test
	void case2() {
		in.input("1");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("100000");
		ProblemB.main(null);
		assertResultIs("7927");
	}
}
