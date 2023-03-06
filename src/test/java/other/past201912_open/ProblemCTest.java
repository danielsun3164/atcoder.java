package other.past201912_open;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 18 25 20 9 13", "18");
	}

	@Test
	void case2() {
		check("95 96 97 98 99 100", "98");
	}

	@Test
	void case3() {
		check("19 92 3 35 78 1", "35");
	}
}
