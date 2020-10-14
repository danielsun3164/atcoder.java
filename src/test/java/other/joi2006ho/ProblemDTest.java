package other.joi2006ho;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "1 3\n" + "3 4\n" + "1 4\n" + "2 7\n" + "5 7\n" + "6 7\n" + "1 7", "5");
	}

	@Test
	void case2() {
		check("6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "4 5\n" + "1 5\n" + "2 6", "6");
	}

	@Test
	void case3() {
		check("7\n" + "1 3\n" + "2 4\n" + "3 5\n" + "4 6\n" + "6 7\n" + "2 6\n" + "4 7", "4");
	}
}
