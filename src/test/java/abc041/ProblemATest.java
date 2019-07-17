package abc041;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("atcoder\n" + "3");
		ProblemA.main(null);
		assertResultIs("c");
	}

	@Test
	void test_Case2() {
		in.input("beginner\n" + "1");
		ProblemA.main(null);
		assertResultIs("b");
	}

	@Test
	void test_Case3() {
		in.input("contest\n" + "7");
		ProblemA.main(null);
		assertResultIs("t");
	}

	@Test
	void test_Case4() {
		in.input("z\n" + "1");
		ProblemA.main(null);
		assertResultIs("z");
	}
}
