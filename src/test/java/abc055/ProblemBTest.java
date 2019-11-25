package abc055;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("10");
		ProblemB.main(null);
		assertResultIs("3628800");
	}

	@Test
	void case3() {
		in.input("100000");
		ProblemB.main(null);
		assertResultIs("457992974");
	}
}
