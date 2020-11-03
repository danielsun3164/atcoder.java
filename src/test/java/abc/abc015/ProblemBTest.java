package abc.abc015;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "0 1 3 8", "4");
	}

	@Test
	void case2() {
		check("5\n" + "1 4 9 10 15", "8");
	}
}
