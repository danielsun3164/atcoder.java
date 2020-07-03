package past201912;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("6 7\n" + "1 1 2\n" + "1 2 3\n" + "1 3 4\n" + "1 1 5\n" + "1 5 6\n" + "3 1\n" + "2 6");
		ProblemE.main(null);
		assertResultIs("NYYNYY" + LF + "NNYNNN" + LF + "NNNYNN" + LF + "NNNNNN" + LF + "NNNNNY" + LF + "YNNNYN");
	}
}
