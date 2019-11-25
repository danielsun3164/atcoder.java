package abc051;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("2 2");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("5 15");
		ProblemB.main(null);
		assertResultIs("1");
	}
}
