package abc028;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("BEAF");
		ProblemB.main(null);
		assertResultIs("1 1 0 0 1 1");
	}

	@Test
	void case2() {
		in.input("DECADE");
		ProblemB.main(null);
		assertResultIs("1 0 1 2 2 0");
	}

	@Test
	void case3() {
		in.input("ABBCCCDDDDEEEEEFFFFFF");
		ProblemB.main(null);
		assertResultIs("1 2 3 4 5 6");
	}
}
