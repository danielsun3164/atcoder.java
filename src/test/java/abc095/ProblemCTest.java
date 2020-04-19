package abc095;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1500 2000 1600 3 2");
		ProblemC.main(null);
		assertResultIs("7900");
	}

	@Test
	void case2() {
		in.input("1500 2000 1900 3 2");
		ProblemC.main(null);
		assertResultIs("8500");
	}

	@Test
	void case3() {
		in.input("1500 2000 500 90000 100000");
		ProblemC.main(null);
		assertResultIs("100000000");
	}
}
