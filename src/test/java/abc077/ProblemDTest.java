package abc077;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("6");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("41");
		ProblemD.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("79992");
		ProblemD.main(null);
		assertResultIs("36");
	}
}
