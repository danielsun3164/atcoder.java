package abc013;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "6");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("6\n" + "4");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("8\n" + "1");
		ProblemB.main(null);
		assertResultIs("3");
	}
}
