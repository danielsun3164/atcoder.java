package abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("198 1.10");
		ProblemC.main(null);
		assertResultIs("217");
	}

	@Test
	void case2() {
		in.input("1 0.01");
		ProblemC.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("1000000000000000 9.99");
		ProblemC.main(null);
		assertResultIs("9990000000000000");
	}
}
