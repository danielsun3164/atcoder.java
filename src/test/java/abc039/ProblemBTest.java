package abc039;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("1");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("981506241");
		ProblemB.main(null);
		assertResultIs("177");
	}

	@Test
	void case3() {
		in.input("390625");
		ProblemB.main(null);
		assertResultIs("25");
	}
}
