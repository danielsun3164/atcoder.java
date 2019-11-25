package abc065;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("4 3 6");
		ProblemA.main(null);
		assertResultIs("safe");
	}

	@Test
	void case2() {
		in.input("6 5 1");
		ProblemA.main(null);
		assertResultIs("delicious");
	}

	@Test
	void case3() {
		in.input("3 7 12");
		ProblemA.main(null);
		assertResultIs("dangerous");
	}
}
