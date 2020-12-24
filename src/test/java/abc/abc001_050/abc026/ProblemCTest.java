package abc.abc001_050.abc026;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1\n" + "1\n" + "1\n" + "1", "3");
	}

	@Test
	void case2() {
		check("7\n" + "1\n" + "1\n" + "2\n" + "2\n" + "3\n" + "3", "7");
	}

	@Test
	void case3() {
		check("6\n" + "1\n" + "2\n" + "3\n" + "3\n" + "2", "11");
	}

	@Test
	void case4() {
		check("10\n" + "1\n" + "2\n" + "3\n" + "4\n" + "5\n" + "6\n" + "7\n" + "8\n" + "9", "1023");
	}
}
