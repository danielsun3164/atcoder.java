package abc028;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("80");
		ProblemA.main(null);
		assertResultIs("Good");
	}

	@Test
	void case2() {
		in.input("100");
		ProblemA.main(null);
		assertResultIs("Perfect");
	}

	@Test
	void case3() {
		in.input("59");
		ProblemA.main(null);
		assertResultIs("Bad");
	}

	@Test
	void case4() {
		in.input("95");
		ProblemA.main(null);
		assertResultIs("Great");
	}
}
