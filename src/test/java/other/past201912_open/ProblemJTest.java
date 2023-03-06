package other.past201912_open;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemJTest extends TestBase {

	@Test
	void case1() {
		check("5 6\n" + "9 9 9 9 1 0\n" + "9 9 9 9 1 9\n" + "9 9 9 1 1 1\n" + "9 1 1 1 9 1\n" + "0 1 9 9 9 0", "10");
	}

	@Test
	void case2() {
		check("10 10\n" + "1 2 265 1544 0 1548 4334 9846 58 0\n" + "21 0 50 44 2 388 5 0 0 4\n"
				+ "170 0 2 1 54 1379 50 3 41 0\n" + "310 0 1 0 2163 0 226 26 3 12\n" + "151 33 0 9 0 0 0 36 365 2286\n"
				+ "0 3 12 3 9 317 645 100 21 4\n" + "52 1 569 0 144 0 6 202 25 0\n"
				+ "8869 19 2058 1948 1252 1002 7 1750 0 5\n" + "0 3 8 29 2 4403 0 0 0 5\n"
				+ "0 17 93 9367 159 6 1 216 0 0", "246");
	}
}
