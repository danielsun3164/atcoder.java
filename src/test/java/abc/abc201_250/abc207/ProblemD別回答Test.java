package abc.abc201_250.abc207;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "0 0\n" + "0 1\n" + "1 0\n" + "2 0\n" + "3 0\n" + "3 1", "Yes");
	}

	@Test
	void case2() {
		check("3\n" + "1 0\n" + "1 1\n" + "3 0\n" + "-1 0\n" + "-1 1\n" + "-3 0", "No");
	}

	@Test
	void case3() {
		check("4\n" + "0 0\n" + "2 9\n" + "10 -2\n" + "-6 -7\n" + "0 0\n" + "2 9\n" + "10 -2\n" + "-6 -7", "Yes");
	}

	@Test
	void case4() {
		check("6\n" + "10 5\n" + "-9 3\n" + "1 -5\n" + "-6 -5\n" + "6 9\n" + "-9 0\n" + "-7 -10\n" + "-10 -5\n"
				+ "5 4\n" + "9 0\n" + "0 -10\n" + "-10 -2", "Yes");
	}
}
