package abc172;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("cupofcoffee\n" + "cupofhottea");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("abcde\n" + "bcdea");
		ProblemB.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("apple\n" + "apple");
		ProblemB.main(null);
		assertResultIs("0");
	}
}
