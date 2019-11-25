package abc002;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1 0 3 0 2 5");
		ProblemC.main(null);
		assertResultIs(5.0d);
	}

	@Test
	void case2() {
		in.input("-1 -2 3 4 5 6");
		ProblemC.main(null);
		assertResultIs(2.0d);
	}

	@Test
	void case3() {
		in.input("298 520 903 520 4 663");
		ProblemC.main(null);
		assertResultIs(43257.5d);
	}
}
