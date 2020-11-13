package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 4\n" + "2 5\n" + "0 6", "Yes" + LF + "4" + LF + "2" + LF + "0");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 4\n" + "2 5\n" + "0 6", "No");
	}
}
