package abc017;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4 6\n" + "1 3 30\n" + "2 3 40\n" + "3 6 25\n" + "6 6 10");
		ProblemC.main(null);
		assertResultIs("80");
	}

	@Test
	void case2() {
		in.input("2 7\n" + "1 3 90\n" + "5 7 90");
		ProblemC.main(null);
		assertResultIs("180");
	}

	@Test
	void case3() {
		in.input("1 4\n" + "1 4 70");
		ProblemC.main(null);
		assertResultIs("0");
	}
}
