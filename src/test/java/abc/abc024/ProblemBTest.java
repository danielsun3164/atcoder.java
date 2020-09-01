package abc.abc024;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 10\n" + "20\n" + "100\n" + "105\n" + "217\n" + "314", "45");
	}

	@Test
	void case2() {
		check("10 10\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "8\n" + "9\n" + "10", "19");
	}

	@Test
	void case3() {
		check("10 100000\n" + "3\n" + "31\n" + "314\n" + "3141\n" + "31415\n" + "314159\n" + "400000\n" + "410000\n"
				+ "500000\n" + "777777", "517253");
	}
}
