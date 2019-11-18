package abc069;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3 4");
		ProblemA.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case2() {
		in.input("2 2");
		ProblemA.main(null);
		assertResultIs("1");
	}
}
