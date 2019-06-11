package abc020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4 2");
		ProblemD.main(null);
		assertResultIs("14");
	}

	@Test
	void test_Case2() {
		in.input("10000 100");
		ProblemD.main(null);
		assertResultIs("865504986");
	}

	@Test
	void test_Case3() {
		in.input("1000000000 90");
		ProblemD.main(null);
		assertResultIs("50001213");
	}

	@Test
	void test_Case4() {
		in.input("1000000000 999999900");
		ProblemD.main(null);
		assertResultIs("231285006");
	}
}
