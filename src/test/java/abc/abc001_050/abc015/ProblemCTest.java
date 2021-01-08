package abc.abc001_050.abc015;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "1 3 5 17\n" + "2 4 2 3\n" + "1 3 2 9", "Found");
	}

	@Test
	void case2() {
		check("5 3\n" + "89 62 15\n" + "44 36 17\n" + "4 24 24\n" + "25 98 99\n" + "66 33 57", "Nothing");
	}
}
