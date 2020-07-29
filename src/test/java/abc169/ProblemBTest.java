package abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "1000000000 1000000000");
		ProblemB.main(null);
		assertResultIs("1000000000000000000");
	}

	@Test
	void case2() {
		in.input("3\n" + "101 9901 999999000001");
		ProblemB.main(null);
		assertResultIs("-1");
	}

	@Test
	void case3() {
		in.input("31\n" + "4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4 6 2 6 4 3 3 8 3 2 7 9 5 0");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
