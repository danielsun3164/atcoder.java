package abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("15\n" + "10");
		ProblemA.main(null);
		assertResultIs("5");
	}

	@Test
	void test_Case2() {
		in.input("0\n" + "0");
		ProblemA.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("5\n" + "20");
		ProblemA.main(null);
		assertResultIs("-15");
	}
}
