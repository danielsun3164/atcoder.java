package abc041;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "140 180 160");
		ProblemC.main(null);
		assertResultIs("2" + LF + "3" + LF + "1");
	}

	@Test
	void case2() {
		in.input("2\n" + "1000000000 1");
		ProblemC.main(null);
		assertResultIs("1" + LF + "2");
	}

	@Test
	void case3() {
		in.input("8\n" + "3 1 4 15 9 2 6 5");
		ProblemC.main(null);
		assertResultIs("4" + LF + "5" + LF + "7" + LF + "8" + LF + "3" + LF + "1" + LF + "6" + LF + "2");
	}
}
