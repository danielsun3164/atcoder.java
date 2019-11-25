package abc006;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("6\n" + "1\n" + "3\n" + "5\n" + "2\n" + "4\n" + "6");
		ProblemD.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("5\n" + "5\n" + "4\n" + "3\n" + "2\n" + "1");
		ProblemD.main(null);
		assertResultIs("4");
	}

	@Test
	void case3() {
		in.input("7\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7");
		ProblemD.main(null);
		assertResultIs("0");
	}
}
