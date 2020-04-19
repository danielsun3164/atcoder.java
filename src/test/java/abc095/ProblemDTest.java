package abc095;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3 20\n" + "2 80\n" + "9 120\n" + "16 1");
		ProblemD.main(null);
		assertResultIs("191");
	}

	@Test
	void case2() {
		in.input("3 20\n" + "2 80\n" + "9 1\n" + "16 120");
		ProblemD.main(null);
		assertResultIs("192");
	}

	@Test
	void case3() {
		in.input("1 100000000000000\n" + "50000000000000 1");
		ProblemD.main(null);
		assertResultIs("0");
	}

	@Test
	void case4() {
		in.input("15 10000000000\n" + "400000000 1000000000\n" + "800000000 1000000000\n" + "1900000000 1000000000\n"
				+ "2400000000 1000000000\n" + "2900000000 1000000000\n" + "3300000000 1000000000\n"
				+ "3700000000 1000000000\n" + "3800000000 1000000000\n" + "4000000000 1000000000\n"
				+ "4100000000 1000000000\n" + "5200000000 1000000000\n" + "6600000000 1000000000\n"
				+ "8000000000 1000000000\n" + "9300000000 1000000000\n" + "9700000000 1000000000");
		ProblemD.main(null);
		assertResultIs("6500000000");
	}
}
