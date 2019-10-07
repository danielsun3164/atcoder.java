package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX13Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("3\n" + "2 1 4");
		ProblemEX13.main(null);
		assertResultIs("0" + LF + "1" + LF + "2");
	}

	@Test
	void test_Case2() {
		in.input("2\n" + "80 70");
		ProblemEX13.main(null);
		assertResultIs("5" + LF + "5");
	}

	@Test
	void test_Case3() {
		in.input("5\n" + "100 100 100 100 100");
		ProblemEX13.main(null);
		assertResultIs("0" + LF + "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@Test
	void test_Case4() {
		in.input("10\n" + "53 21 99 83 75 40 33 62 18 100");
		ProblemEX13.main(null);
		assertResultIs("5" + LF + "37" + LF + "41" + LF + "25" + LF + "17" + LF + "18" + LF + "25" + LF + "4" + LF
				+ "40" + LF + "42");
	}
}
