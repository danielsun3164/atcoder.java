package abc070;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("0 75 25 100");
		ProblemB.main(null);
		assertResultIs("50");
	}

	@Test
	void test_Case2() {
		in.input("0 33 66 99");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void test_Case3() {
		in.input("10 90 20 80");
		ProblemB.main(null);
		assertResultIs("60");
	}
}
