package abc041;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 3 4");
		ProblemB.main(null);
		assertResultIs("24");
	}

	@Test
	void test_Case2() {
		in.input("10000 1000 100");
		ProblemB.main(null);
		assertResultIs("1000000000");
	}

	@Test
	void test_Case3() {
		in.input("100000 1 100000");
		ProblemB.main(null);
		assertResultIs("999999937");
	}

	@Test
	void test_Case4() {
		in.input("1000000000 1000000000 1000000000");
		ProblemB.main(null);
		assertResultIs("999999664");
	}
}
