package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX22Test extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "5 2\n" + "2 7\n" + "4 1");
		ProblemEX22.main(null);
		assertResultIs("4 1" + LF + "5 2" + LF + "2 7");
	}

	@Test
	void case2() {
		in.input("5\n" + "1 2\n" + "3 4\n" + "5 6\n" + "7 8\n" + "9 10");
		ProblemEX22.main(null);
		assertResultIs("1 2" + LF + "3 4" + LF + "5 6" + LF + "7 8" + LF + "9 10");
	}
}
