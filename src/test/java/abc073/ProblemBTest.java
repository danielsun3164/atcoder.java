package abc073;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("1\n" + "24 30");
		ProblemB.main(null);
		assertResultIs("7");
	}

	@Test
	void case2() {
		in.input("2\n" + "6 8\n" + "3 3");
		ProblemB.main(null);
		assertResultIs("4");
	}
}
