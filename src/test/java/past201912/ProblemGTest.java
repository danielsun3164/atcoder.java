package past201912;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		in.input("6\n" + "10 10 -10 -10 -10\n" + "10 -10 -10 -10\n" + "-10 -10 -10\n" + "10 -10\n" + "-10");
		ProblemG.main(null);
		assertResultIs("40");
	}

	@Test
	void case2() {
		in.input("3\n" + "1 1\n" + "1");
		ProblemG.main(null);
		assertResultIs("3");
	}
}
