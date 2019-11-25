package abc067;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("6\n" + "1 2 3 4 5 6");
		ProblemC.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("2\n" + "10 -10");
		ProblemC.main(null);
		assertResultIs("20");
	}
}
