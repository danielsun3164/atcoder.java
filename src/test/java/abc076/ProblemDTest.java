package abc076;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("1\n" + "100\n" + "30");
		ProblemD.main(null);
		assertResultIs(2100.0d);
	}

	@Test
	void case2() {
		in.input("2\n" + "60 50\n" + "34 38");
		ProblemD.main(null);
		assertResultIs(2632.0d);
	}

	@Test
	void case3() {
		in.input("3\n" + "12 14 2\n" + "6 2 7");
		ProblemD.main(null);
		assertResultIs(76.0d);
	}

	@Test
	void case4() {
		in.input("1\n" + "9\n" + "10");
		ProblemD.main(null);
		assertResultIs(20.25d);
	}

	@Test
	void case5() {
		in.input("10\n" + "64 55 27 35 76 119 7 18 49 100\n" + "29 19 31 39 27 48 41 87 55 70");
		ProblemD.main(null);
		assertResultIs(20291.0d);
	}
}
