package abc013;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("A");
		ProblemA.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("B");
		ProblemA.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("C");
		ProblemA.main(null);
		assertResultIs("3");
	}

	@Test
	void case4() {
		in.input("D");
		ProblemA.main(null);
		assertResultIs("4");
	}
}
