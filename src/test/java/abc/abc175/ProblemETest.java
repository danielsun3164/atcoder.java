package abc.abc175;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2 3\n" + "1 1 3\n" + "2 1 4\n" + "1 2 5", "8");
	}

	@Test
	void case2() {
		check("2 5 5\n" + "1 1 3\n" + "2 4 20\n" + "1 2 1\n" + "1 3 4\n" + "1 4 2", "29");
	}

	@Test
	void case3() {
		check("4 5 10\n" + "2 5 12\n" + "1 5 12\n" + "2 3 15\n" + "1 2 20\n" + "1 1 28\n" + "2 4 26\n" + "3 2 27\n"
				+ "4 5 21\n" + "3 5 10\n" + "1 3 10", "142");
	}
}
