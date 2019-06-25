package abc025;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("0 15 0\n" + "0 0 25\n" + "20 10\n" + "0 0\n" + "25 0");
		ProblemC.main(null);
		assertResultIs("15" + LF + "80");
	}

	@Test
	void test_Case2() {
		in.input("18 22 15\n" + "11 16 17\n" + "4 25\n" + "22 15\n" + "10 4");
		ProblemC.main(null);
		assertResultIs("72" + LF + "107");
	}
}
