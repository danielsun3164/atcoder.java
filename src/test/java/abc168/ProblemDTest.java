package abc168;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		in.input("4 4\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 2");
		ProblemD.main(null);
		assertResultIs("Yes" + LF + "1" + LF + "2" + LF + "2");
	}

	@Test
	void case2() {
		in.input("6 9\n" + "3 4\n" + "6 1\n" + "2 4\n" + "5 3\n" + "4 6\n" + "1 5\n" + "6 2\n" + "4 5\n" + "5 6");
		ProblemD.main(null);
		assertResultIn("Yes" + LF + "6" + LF + "5" + LF + "5" + LF + "1" + LF + "1",
				"Yes" + LF + "6" + LF + "5" + LF + "6" + LF + "1" + LF + "1");
	}
}
