package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemITest extends TestBase {

	@Test
	void case1() {
		check("abcbcba", "21");
	}

	@Test
	void case2() {
		check("mississippi", "53");
	}

	@Test
	void case3() {
		check("ababacaca", "33");
	}

	@Test
	void case4() {
		check("aaaaa", "5");
	}
}
