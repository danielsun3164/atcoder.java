package abc167;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("2 1 1 3");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("1 2 3 4");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("2000000000 0 0 2000000000");
		ProblemB.main(null);
		assertResultIs("2000000000");
	}
}
