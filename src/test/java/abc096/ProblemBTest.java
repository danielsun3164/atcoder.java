package abc096;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("5 3 11\n" + "1");
		ProblemB.main(null);
		assertResultIs("30");
	}

	@Test
	void case2() {
		in.input("3 3 4\n" + "2");
		ProblemB.main(null);
		assertResultIs("22");
	}
}
