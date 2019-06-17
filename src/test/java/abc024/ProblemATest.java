package abc024;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("100 200 50 20\n" + "40 10");
		ProblemA.main(null);
		assertResultIs("3500");
	}

	@Test
	void test_Case2() {
		in.input("400 1000 400 21\n" + "10 10");
		ProblemA.main(null);
		assertResultIs("14000");
	}

	@Test
	void test_Case3() {
		in.input("400 1000 400 20\n" + "10 10");
		ProblemA.main(null);
		assertResultIs("6000");
	}
}
