package abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 2 7");
		ProblemA.main(null);
		assertResultIs("B");
	}

	@Test
	void test_Case2() {
		in.input("1 999 1000");
		ProblemA.main(null);
		assertResultIs("A");
	}
}
