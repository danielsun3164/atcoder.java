package abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("aca\n" + "accc\n" + "ca");
		ProblemB.main(null);
		assertResultIs("A");
	}

	@Test
	void test_Case2() {
		in.input("abcb\n" + "aacb\n" + "bccc");
		ProblemB.main(null);
		assertResultIs("C");
	}
}
