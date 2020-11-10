package other.past201912open;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemITest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "YYY 100\n" + "YYN 20\n" + "YNY 10\n" + "NYY 25", "30");
	}

	@Test
	void case2() {
		check("5 4\n" + "YNNNN 10\n" + "NYNNN 10\n" + "NNYNN 10\n" + "NNNYN 10", "-1");
	}

	@Test
	void case3() {
		check("10 14\n" + "YNNYNNNYYN 774472905\n" + "YYNNNNNYYY 75967554\n" + "NNNNNNNNNN 829389188\n"
				+ "NNNNYYNNNN 157257407\n" + "YNNYNNYNNN 233604939\n" + "NYYNNNNNYY 40099278\n"
				+ "NNNNYNNNNN 599672237\n" + "NNNYNNNNYY 511018842\n" + "NNNYNNYNYN 883299962\n"
				+ "NNNNNNNNYN 883093359\n" + "NNNNNYNYNY 54742561\n" + "NYNNYYYNNY 386272705\n"
				+ "NNNNYYNNNN 565075143\n" + "NNYNYNNNYN 123300589", "451747367");
	}
}
