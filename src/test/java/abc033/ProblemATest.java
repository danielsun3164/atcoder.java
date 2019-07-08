package abc033;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2222");
		ProblemA.main(null);
		assertResultIs("SAME");
	}

	@Test
	void test_Case2() {
		in.input("1221");
		ProblemA.main(null);
		assertResultIs("DIFFERENT");
	}

	@Test
	void test_Case3() {
		in.input("0000");
		ProblemA.main(null);
		assertResultIs("SAME");
	}
}
