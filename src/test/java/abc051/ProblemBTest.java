package abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 2");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case2() {
		in.input("5 15");
		ProblemB.main(null);
		assertResultIs("1");
	}
}
