package abc079;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("5");
		ProblemB.main(null);
		assertResultIs("11");
	}

	@Test
	void case2() {
		in.input("86");
		ProblemB.main(null);
		assertResultIs("939587134549734843");
	}
}
