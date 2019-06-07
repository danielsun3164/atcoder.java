package abc005;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4 8");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case2() {
		in.input("4 7");
		ProblemA.main(null);
		assertResultIs("1");
	}

	@Test
	void test_Case3() {
		in.input("4 3");
		ProblemA.main(null);
		assertResultIs("0");
	}
}
