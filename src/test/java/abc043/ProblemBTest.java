package abc043;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("01B0");
		ProblemB.main(null);
		assertResultIs("00");
	}

	@Test
	void test_Case2() {
		in.input("0BB1");
		ProblemB.main(null);
		assertResultIs("1");
	}
}
