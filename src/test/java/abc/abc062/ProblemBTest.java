package abc.abc062;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "abc\n" + "arc", "#####" + LF + "#abc#" + LF + "#arc#" + LF + "#####");
	}

	@Test
	void case2() {
		check("1 1\n" + "z", "###" + LF + "#z#" + LF + "###");
	}
}
