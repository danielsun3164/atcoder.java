package abc041;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("2 3 4");
		ProblemB.main(null);
		assertResultIs("24");
	}

	@Test
	void case2() {
		in.input("10000 1000 100");
		ProblemB.main(null);
		assertResultIs("1000000000");
	}

	@Test
	void case3() {
		in.input("100000 1 100000");
		ProblemB.main(null);
		assertResultIs("999999937");
	}

	@Test
	void case4() {
		in.input("1000000000 1000000000 1000000000");
		ProblemB.main(null);
		assertResultIs("999999664");
	}
}
