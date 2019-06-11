package abc020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1");
		ProblemA.main(null);
		assertResultIs("ABC");
	}

	@Test
	void test_Case2() {
		in.input("2");
		ProblemA.main(null);
		assertResultIs("chokudai");
	}
}
