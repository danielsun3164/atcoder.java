package abc.abc051_100.abc075;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7 7\n" + "1 3\n" + "2 7\n" + "3 4\n" + "4 5\n" + "4 6\n" + "5 6\n" + "6 7", "4");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2\n" + "1 3\n" + "2 3", "0");
	}

	@Test
	void case3() {
		check("6 5\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "5 6", "5");
	}
}
