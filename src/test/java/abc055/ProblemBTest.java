package abc055;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case2() {
		in.input("10");
		ProblemB.main(null);
		assertResultIs("3628800");
	}

	@Test
	void test_Case3() {
		in.input("100000");
		ProblemB.main(null);
		assertResultIs("457992974");
	}
}
