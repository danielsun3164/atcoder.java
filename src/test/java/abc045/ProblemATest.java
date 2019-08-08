package abc045;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "4\n" + "2");
		ProblemA.main(null);
		assertResultIs("7");
	}

	@Test
	void test_Case2() {
		in.input("4\n" + "4\n" + "4");
		ProblemA.main(null);
		assertResultIs("16");
	}
}
