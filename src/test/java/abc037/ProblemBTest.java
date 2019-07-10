package abc037;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5 2\n" + "1 3 10\n" + "2 4 20");
		ProblemB.main(null);
		assertResultIs("10" + LF + "20" + LF + "20" + LF + "20" + LF + "0");
	}

	@Test
	void test_Case2() {
		in.input("10 4\n" + "2 7 22\n" + "3 5 4\n" + "6 10 1\n" + "4 4 12");
		ProblemB.main(null);
		assertResultIs("0" + LF + "22" + LF + "4" + LF + "12" + LF + "4" + LF + "1" + LF + "1" + LF + "1" + LF + "1"
				+ LF + "1");
	}
}
