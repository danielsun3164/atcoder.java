package abc166;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "2\n" + "1 3\n" + "1\n" + "3");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("3 3\n" + "1\n" + "3\n" + "1\n" + "3\n" + "1\n" + "3");
		ProblemB.main(null);
		assertResultIs("2");
	}
}
