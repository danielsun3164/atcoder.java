package abc067;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 3\n" + "1 2 3 4 5");
		ProblemB.main(null);
		assertResultIs("12");
	}

	@Test
	void test_Case2() {
		in.input("15 14\n" + "50 26 27 21 41 7 42 35 7 5 5 36 39 1 45");
		ProblemB.main(null);
		assertResultIs("386");
	}
}
