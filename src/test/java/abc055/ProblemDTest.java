package abc055;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("6\n" + "ooxoox");
		ProblemD.main(null);
		assertResultIs("SSSWWS");
	}

	@Test
	void test_Case2() {
		in.input("3\n" + "oox");
		ProblemD.main(null);
		assertResultIs("-1");
	}

	@Test
	void test_Case3() {
		in.input("10\n" + "oxooxoxoox");
		ProblemD.main(null);
		assertResultIs("SSWWSSSWWS");
	}
}
