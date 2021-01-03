package other.exawizards2019;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 5 4\n" + "EEWW\n" + "NSNNS\n" + "4 1 1 4\n" + "1 3 1 2\n" + "4 2 3 2\n" + "3 3 3 5",
				"6" + LF + "11" + LF + "5" + LF + "4");
	}

	@Test
	void case2() {
		check("3 3 2\n" + "EEE\n" + "SSS\n" + "1 1 3 3\n" + "3 3 1 1", "4" + LF + "-1");
	}

	@Test
	void case3() {
		check("9 7 10\n" + "EEEEEWEWW\n" + "NSSSNSN\n" + "4 6 9 2\n" + "3 7 6 7\n" + "7 5 3 5\n" + "1 1 8 1\n"
				+ "4 3 5 4\n" + "7 4 6 4\n" + "2 5 8 6\n" + "6 6 2 7\n" + "2 4 7 5\n" + "7 2 9 7",
				"9" + LF + "-1" + LF + "4" + LF + "9" + LF + "2" + LF + "3" + LF + "7" + LF + "7" + LF + "6" + LF
						+ "-1");
	}
}
