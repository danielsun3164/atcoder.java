package abc174;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("25");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void case2() {
		in.input("30");
		ProblemA.main(null);
		assertResultIs("Yes");
	}
}
