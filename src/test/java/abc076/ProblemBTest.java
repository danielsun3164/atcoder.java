package abc076;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "3");
		ProblemB.main(null);
		assertResultIs("10");
	}

	@Test
	void case2() {
		in.input("10\n" + "10");
		ProblemB.main(null);
		assertResultIs("76");
	}
}
