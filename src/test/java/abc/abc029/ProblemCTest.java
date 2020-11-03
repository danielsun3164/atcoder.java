package abc.abc029;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1", "a" + LF + "b" + LF + "c");
	}

	@Test
	void case2() {
		check("2",
				"aa" + LF + "ab" + LF + "ac" + LF + "ba" + LF + "bb" + LF + "bc" + LF + "ca" + LF + "cb" + LF + "cc");
	}
}
