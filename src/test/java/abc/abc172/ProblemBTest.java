package abc.abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("cupofcoffee\n" + "cupofhottea", "4");
	}

	@Test
	void case2() {
		check("abcde\n" + "bcdea", "5");
	}

	@Test
	void case3() {
		check("apple\n" + "apple", "0");
	}
}
