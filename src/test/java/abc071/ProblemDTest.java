package abc071;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "aab\n" + "ccb");
		ProblemD.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("1\n" + "Z\n" + "Z");
		ProblemD.main(null);
		assertResultIs("3");
	}

	@Test
	void case3() {
		in.input("52\n" + "RvvttdWIyyPPQFFZZssffEEkkaSSDKqcibbeYrhAljCCGGJppHHn\n"
				+ "RLLwwdWIxxNNQUUXXVVMMooBBaggDKqcimmeYrhAljOOTTJuuzzn");
		ProblemD.main(null);
		assertResultIs("958681902");
	}
}
