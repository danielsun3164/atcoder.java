package abc036;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "ooxx\n" + "xoox\n" + "xxxx\n" + "xxxx");
		ProblemB.main(null);
		assertResultIs("xxxo" + LF + "xxoo" + LF + "xxox" + LF + "xxxx");
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "ooxx\n" + "xxxx\n" + "xxxx\n" + "xxxx");
		ProblemB.main(null);
		assertResultIs("xxxo" + LF + "xxxo" + LF + "xxxx" + LF + "xxxx");
	}
}
