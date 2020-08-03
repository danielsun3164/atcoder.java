package abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("2 2");
		ProblemE.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("2 3");
		ProblemE.main(null);
		assertResultIs("18");
	}

	@Test
	void case3() {
		in.input("141421 356237");
		ProblemE.main(null);
		assertResultIs("881613484");
	}
}
