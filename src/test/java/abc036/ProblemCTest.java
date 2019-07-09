package abc036;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("5\n" + "3\n" + "3\n" + "1\n" + "6\n" + "1");
		ProblemC.main(null);
		assertResultIs("1" + LF + "1" + LF + "0" + LF + "2" + LF + "0");
	}

	@Test
	void test_Case2() {
		in.input("5\n" + "3\n" + "2\n" + "1\n" + "6\n" + "4");
		ProblemC.main(null);
		assertResultIs("2" + LF + "1" + LF + "0" + LF + "4" + LF + "3");
	}
}
