package abc023;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "5 6\n" + "12 4\n" + "14 7\n" + "21 2");
		ProblemD.main(null);
		assertResultIs("23");
	}

	@Test
	void case2() {
		in.input("6\n" + "100 1\n" + "100 1\n" + "100 1\n" + "100 1\n" + "100 1\n" + "1 30");
		ProblemD.main(null);
		assertResultIs("105");
	}
}
