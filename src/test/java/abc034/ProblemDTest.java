package abc034;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 2\n" + "100 15\n" + "300 20\n" + "200 30");
		ProblemD.main(null);
		assertResultIs(25.0d);
	}

	@Test
	void case2() {
		in.input("4 3\n" + "16 51\n" + "51 64\n" + "61 57\n" + "4 26");
		ProblemD.main(null);
		assertResultIsAbout(59.039062499999993d, 0.000000001d);
	}
}
