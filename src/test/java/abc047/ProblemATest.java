package abc047;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("10 30 20");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void test_Case2() {
		in.input("30 30 100");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void test_Case3() {
		in.input("56 25 31");
		ProblemA.main(null);
		assertResultIs("Yes");
	}
}
