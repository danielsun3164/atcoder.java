package abc167;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4 5\n" + "3 2 4 1");
		ProblemD.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("6 727202214173249351\n" + "6 5 2 5 3 2");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("4 2\n" + "3 2 4 1");
		ProblemD.main(null);
		assertResultIs("4");
	}
}
