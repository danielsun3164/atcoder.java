package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX21Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("1000000 100");
		ProblemEX21.main(null);
		assertResultIs("f0: 1" + LF + "f1: 1000100" + LF + "f2: 20000000" + LF + "f3: 9" + LF + "f4: -1" + LF
				+ "f5: -1404227328");
	}

	@Test
	void test_Case2() {
		in.input("1 1");
		ProblemEX21.main(null);
		assertResultIs("f0: 1" + LF + "f1: 2" + LF + "f2: 1" + LF + "f3: 9" + LF + "f4: -1" + LF + "f5: 0");
	}
}
