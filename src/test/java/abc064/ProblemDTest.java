package abc064;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "())");
		ProblemD.main(null);
		assertResultIs("(())");
	}

	@Test
	void test_Case2() {
		in.input("6\n" + ")))())");
		ProblemD.main(null);
		assertResultIs("(((()))())");
	}

	@Test
	void test_Case3() {
		in.input("8\n" + "))))((((");
		ProblemD.main(null);
		assertResultIs("(((())))(((())))");
	}
}
