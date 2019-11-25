package abc021;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("7\n" + "1 7\n" + "8\n" + "1 2\n" + "1 3\n" + "4 2\n" + "4 3\n" + "4 5\n" + "4 6\n" + "7 5\n" + "7 6");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("7\n" + "1 7\n" + "9\n" + "1 2\n" + "1 3\n" + "4 2\n" + "4 3\n" + "4 5\n" + "4 6\n" + "7 5\n" + "7 6\n"
				+ "4 7");
		ProblemC.main(null);
		assertResultIs("2");
	}
}
