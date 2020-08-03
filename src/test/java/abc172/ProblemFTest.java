package abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "5 3");
		ProblemF.main(null);
		assertResultIs("1");
	}

	@Test
	void case2() {
		in.input("2\n" + "3 5");
		ProblemF.main(null);
		assertResultIs("-1");
	}

	@Test
	void case3() {
		in.input("3\n" + "1 1 2");
		ProblemF.main(null);
		assertResultIs("-1");
	}

	@Test
	void case4() {
		in.input("8\n" + "10 9 8 7 6 5 4 3");
		ProblemF.main(null);
		assertResultIs("3");
	}

	@Test
	void case5() {
		in.input("3\n" + "4294967297 8589934593 12884901890");
		ProblemF.main(null);
		assertResultIs("1");
	}
}
