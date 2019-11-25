package abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("5 2 7");
		ProblemA.main(null);
		assertResultIs("B");
	}

	@Test
	void case2() {
		in.input("1 999 1000");
		ProblemA.main(null);
		assertResultIs("A");
	}
}
