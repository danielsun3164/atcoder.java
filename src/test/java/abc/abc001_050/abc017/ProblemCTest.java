package abc.abc001_050.abc017;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 6\n" + "1 3 30\n" + "2 3 40\n" + "3 6 25\n" + "6 6 10", "80");
	}

	@Test
	void case2() {
		check("2 7\n" + "1 3 90\n" + "5 7 90", "180");
	}

	@Test
	void case3() {
		check("1 4\n" + "1 4 70", "0");
	}
}
