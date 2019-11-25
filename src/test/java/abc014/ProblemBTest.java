package abc014;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("4 5\n" + "1 10 100 1000");
		ProblemB.main(null);
		assertResultIs("101");
	}

	@Test
	void case2() {
		in.input("20 1048575\n" + "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20");
		ProblemB.main(null);
		assertResultIs("210");
	}

	@Test
	void case3() {
		in.input("4 0\n" + "1000 1000 1000 1000");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
