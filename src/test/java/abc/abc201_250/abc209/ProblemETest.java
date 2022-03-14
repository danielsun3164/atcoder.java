package abc.abc201_250.abc209;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "abcd\n" + "bcda\n" + "ada", "Aoki" + LF + "Takahashi" + LF + "Draw");
	}

	@Test
	void case2() {
		check("1\n" + "ABC", "Draw");
	}

	@Test
	void case3() {
		check("5\n" + "eaaaabaa\n" + "eaaaacaa\n" + "daaaaaaa\n" + "eaaaadaa\n" + "daaaafaa",
				"Takahashi" + LF + "Takahashi" + LF + "Takahashi" + LF + "Aoki" + LF + "Takahashi");
	}
}
