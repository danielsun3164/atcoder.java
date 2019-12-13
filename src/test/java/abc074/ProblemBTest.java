package abc074;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("1\n" + "10\n" + "2");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("2\n" + "9\n" + "3 6");
		ProblemB.main(null);
		assertResultIs("12");
	}

	@Test
	void case3() {
		in.input("5\n" + "20\n" + "11 12 9 17 12");
		ProblemB.main(null);
		assertResultIs("74");
	}
}
