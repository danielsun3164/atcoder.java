package abc046;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 2");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("1 10");
		ProblemB.main(null);
		assertResultIs("10");
	}

	@Test
	void test_Case3() {
		in.input("10 8");
		ProblemB.main(null);
		assertResultIs("322828856");
	}
}
