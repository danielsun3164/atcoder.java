package abc053;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1000");
		ProblemA.main(null);
		assertResultIs("ABC");
	}

	@Test
	void test_Case2() {
		in.input("2000");
		ProblemA.main(null);
		assertResultIs("ARC");
	}
}
