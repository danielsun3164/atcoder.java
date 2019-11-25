package abc041;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("atcoder\n" + "3");
		ProblemA.main(null);
		assertResultIs("c");
	}

	@Test
	void case2() {
		in.input("beginner\n" + "1");
		ProblemA.main(null);
		assertResultIs("b");
	}

	@Test
	void case3() {
		in.input("contest\n" + "7");
		ProblemA.main(null);
		assertResultIs("t");
	}

	@Test
	void case4() {
		in.input("z\n" + "1");
		ProblemA.main(null);
		assertResultIs("z");
	}
}
