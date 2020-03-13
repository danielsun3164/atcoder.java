package abc084;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "6 5 1\n" + "1 10 1");
		ProblemC.main(null);
		assertResultIs("12" + LF + "11" + LF + "0");
	}

	@Test
	void case2() {
		in.input("4\n" + "12 24 6\n" + "52 16 4\n" + "99 2 2");
		ProblemC.main(null);
		assertResultIs("187" + LF + "167" + LF + "101" + LF + "0");
	}

	@Test
	void case3() {
		in.input("4\n" + "12 13 1\n" + "44 17 17\n" + "66 4096 64");
		ProblemC.main(null);
		assertResultIs("4162" + LF + "4162" + LF + "4162" + LF + "0");
	}
}
