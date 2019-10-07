package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX20Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("6\n" + "0 0 1 1 4");
		ProblemEX20.main(null);
		assertResultIs("6" + LF + "4" + LF + "1" + LF + "1" + LF + "2" + LF + "1");
	}

	@Test
	void test_Case2() {
		in.input("8\n" + "0 0 1 2 0 3 6");
		ProblemEX20.main(null);
		assertResultIs("8" + LF + "4" + LF + "2" + LF + "3" + LF + "1" + LF + "1" + LF + "2" + LF + "1");
	}
}
