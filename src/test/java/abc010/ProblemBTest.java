package abc010;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "5 8 2");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case2() {
		in.input("9\n" + "1 2 3 4 5 6 7 8 9");
		ProblemB.main(null);
		assertResultIs("8");
	}
}
