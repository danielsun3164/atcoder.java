package abc078;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("A B");
		ProblemA.main(null);
		assertResultIs("<");
	}

	@Test
	void case2() {
		in.input("E C");
		ProblemA.main(null);
		assertResultIs(">");
	}

	@Test
	void case3() {
		in.input("F F");
		ProblemA.main(null);
		assertResultIs("=");
	}
}
