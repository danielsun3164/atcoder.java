package abc007;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void test_Case2() {
		in.input("100");
		ProblemA.main(null);
		assertResultIs("99");
	}

	@Test
	void test_Case3() {
		in.input("1");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
