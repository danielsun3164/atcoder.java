package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX9Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("1 2 3");
		ProblemEX9.main(null);
		assertResultIs("2" + LF + "10" + LF + "100" + LF + "99");
	}

	@Test
	void test_Case2() {
		in.input("3 2 5");
		ProblemEX9.main(null);
		assertResultIs("4" + LF + "28" + LF + "784" + LF + "783");
	}
}
