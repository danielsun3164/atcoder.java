package abc083;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3 20");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("25 100");
		ProblemC.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("314159265 358979323846264338");
		ProblemC.main(null);
		assertResultIs("31");
	}
}
