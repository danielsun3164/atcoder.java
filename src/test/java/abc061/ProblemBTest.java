package abc061;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("4 3\n" + "1 2\n" + "2 3\n" + "1 4");
		ProblemB.main(null);
		assertResultIs("2" + LF + "2" + LF + "1" + LF + "1");
	}

	@Test
	void case2() {
		in.input("2 5\n" + "1 2\n" + "2 1\n" + "1 2\n" + "2 1\n" + "1 2");
		ProblemB.main(null);
		assertResultIs("5" + LF + "5");
	}

	@Test
	void case3() {
		in.input("8 8\n" + "1 2\n" + "3 4\n" + "1 5\n" + "2 8\n" + "3 7\n" + "5 2\n" + "4 1\n" + "6 8");
		ProblemB.main(null);
		assertResultIs("3" + LF + "3" + LF + "2" + LF + "2" + LF + "2" + LF + "1" + LF + "1" + LF + "2");
	}
}
