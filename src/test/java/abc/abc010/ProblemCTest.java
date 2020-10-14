package abc.abc010;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 1 8 2 2 4\n" + "1\n" + "4 5", "NO");
	}

	@Test
	void case2() {
		check("1 1 8 2 2 6\n" + "1\n" + "4 5", "YES");
	}

	@Test
	void case3() {
		check("1 1 8 2 2 5\n" + "1\n" + "4 5", "YES");
	}

	@Test
	void case4() {
		check("7 7 1 1 3 4\n" + "3\n" + "8 1\n" + "1 7\n" + "9 9", "YES");
	}
}
