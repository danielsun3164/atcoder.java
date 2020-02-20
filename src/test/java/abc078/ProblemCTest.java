package abc078;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1 1");
		ProblemC.main(null);
		assertResultIs("3800");
	}

	@Test
	void case2() {
		in.input("10 2");
		ProblemC.main(null);
		assertResultIs("18400");
	}

	@Test
	void case3() {
		in.input("100 5");
		ProblemC.main(null);
		assertResultIs("608000");
	}
}
