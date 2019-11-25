package abc054;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("8 6");
		ProblemA.main(null);
		assertResultIs("Alice");
	}

	@Test
	void case2() {
		in.input("1 1");
		ProblemA.main(null);
		assertResultIs("Draw");
	}

	@Test
	void case3() {
		in.input("13 1");
		ProblemA.main(null);
		assertResultIs("Bob");
	}
}
