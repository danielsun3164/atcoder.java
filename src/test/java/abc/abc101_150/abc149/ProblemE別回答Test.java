package abc.abc101_150.abc149;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemE別回答Test extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "10 14 19 34 33", "202");
	}

	@Test
	void case2() {
		check("9 14\n" + "1 3 5 110 24 21 34 5 3", "1837");
	}

	@Test
	void case3() {
		check("9 73\n" + "67597 52981 5828 66249 75177 64141 40773 79105 16076", "8128170");
	}
}
