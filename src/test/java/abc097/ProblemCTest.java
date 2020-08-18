package abc097;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("aba\n" + "4");
		ProblemC.main(null);
		assertResultIs("b");
	}

	@Test
	void case2() {
		in.input("atcoderandatcodeer\n" + "5");
		ProblemC.main(null);
		assertResultIs("andat");
	}

	@Test
	void case3() {
		in.input("z\n" + "1");
		ProblemC.main(null);
		assertResultIs("z");
	}
}
