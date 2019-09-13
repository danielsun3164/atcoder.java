package abc056;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 2 6");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case2() {
		in.input("3 1 3");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("5 10 1");
		ProblemB.main(null);
		assertResultIs("4");
	}
}
