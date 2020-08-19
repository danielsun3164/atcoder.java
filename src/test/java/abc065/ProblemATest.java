package abc065;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 3 6", "safe");
	}

	@Test
	void case2() {
		check("6 5 1", "delicious");
	}

	@Test
	void case3() {
		check("3 7 12", "dangerous");
	}
}
