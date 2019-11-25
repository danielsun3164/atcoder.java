package abc031;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("300 400\n" + "3\n" + "240\n" + "350\n" + "480");
		ProblemB.main(null);
		assertResultIs("60" + LF + "0" + LF + "-1");
	}

	@Test
	void case2() {
		in.input("50 80\n" + "5\n" + "10000\n" + "50\n" + "81\n" + "80\n" + "0");
		ProblemB.main(null);
		assertResultIs("-1" + LF + "0" + LF + "-1" + LF + "0" + LF + "50");
	}
}
