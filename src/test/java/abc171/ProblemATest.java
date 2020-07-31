package abc171;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("B");
		ProblemA.main(null);
		assertResultIs("A");
	}

	@Test
	void case2() {
		in.input("a");
		ProblemA.main(null);
		assertResultIs("a");
	}
}
