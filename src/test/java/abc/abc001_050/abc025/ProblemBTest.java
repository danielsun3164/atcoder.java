package abc.abc001_050.abc025;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 5 10\n" + "East 7\n" + "West 3\n" + "West 11", "West 8");
	}

	@Test
	void case2() {
		check("3 3 8\n" + "West 6\n" + "East 3\n" + "East 1", "0");
	}

	@Test
	void case3() {
		check("5 25 25\n" + "East 1\n" + "East 1\n" + "West 1\n" + "East 100\n" + "West 1", "East 25");
	}
}
