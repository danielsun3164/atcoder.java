package abc083;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("3 8 7 1");
		ProblemA.main(null);
		assertResultIs("Left");
	}

	@Test
	void case2() {
		in.input("3 4 5 2");
		ProblemA.main(null);
		assertResultIs("Balanced");
	}

	@Test
	void case3() {
		in.input("1 7 6 4");
		ProblemA.main(null);
		assertResultIs("Right");
	}
}
