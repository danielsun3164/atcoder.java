package abc.abc201_250.abc215;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "BGBH", "13");
	}

	@Test
	void case2() {
		check("100\n"
				+ "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBIEIJEIJIJCGCCFGIEBIHFCGFBFAEJIEJAJJHHEBBBJJJGJJJCCCBAAADCEHIIFEHHBGF",
				"330219020");
	}
}
