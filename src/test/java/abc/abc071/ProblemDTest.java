package abc.abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "aab\n" + "ccb", "6");
	}

	@Test
	void case2() {
		check("1\n" + "Z\n" + "Z", "3");
	}

	@Test
	void case3() {
		check("52\n" + "RvvttdWIyyPPQFFZZssffEEkkaSSDKqcibbeYrhAljCCGGJppHHn\n"
				+ "RLLwwdWIxxNNQUUXXVVMMooBBaggDKqcimmeYrhAljOOTTJuuzzn", "958681902");
	}
}
