package abc068;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("7");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case2() {
		in.input("32");
		ProblemB.main(null);
		assertResultIs("32");
	}

	@Test
	void test_Case3() {
		in.input("1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case4() {
		in.input("100");
		ProblemB.main(null);
		assertResultIs("64");
	}
}
