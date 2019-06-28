package abc029;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("1");
		ProblemC.main(null);
		assertResultIs("a" + LF + "b" + LF + "c");
	}

	@Test
	void test_Case2() {
		in.input("2");
		ProblemC.main(null);
		assertResultIs(
				"aa" + LF + "ab" + LF + "ac" + LF + "ba" + LF + "bb" + LF + "bc" + LF + "ca" + LF + "cb" + LF + "cc");
	}
}
