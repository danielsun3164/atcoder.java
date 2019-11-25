package abc030;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	private static double TORELANCE = 0.0001d;

	@Test
	void case1() {
		in.input("15 0");
		ProblemB.main(null);
		assertResultIsAbout(90d, TORELANCE);
	}

	@Test
	void case2() {
		in.input("3 17");
		ProblemB.main(null);
		assertResultIsAbout(3.5d, TORELANCE);
	}

	@Test
	void case3() {
		in.input("0 0");
		ProblemB.main(null);
		assertResultIsAbout(0d, TORELANCE);
	}

	@Test
	void case4() {
		in.input("6 0");
		ProblemB.main(null);
		assertResultIsAbout(180d, TORELANCE);
	}

	@Test
	void case5() {
		in.input("23 59");
		ProblemB.main(null);
		assertResultIsAbout(5.5d, TORELANCE);
	}
}
