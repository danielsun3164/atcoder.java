package abc029;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("1");
		ProblemC.main(null);
		assertResultIs("a" + LF + "b" + LF + "c");
	}

	@Test
	void case2() {
		in.input("2");
		ProblemC.main(null);
		assertResultIs(
				"aa" + LF + "ab" + LF + "ac" + LF + "ba" + LF + "bb" + LF + "bc" + LF + "ca" + LF + "cb" + LF + "cc");
	}
}
