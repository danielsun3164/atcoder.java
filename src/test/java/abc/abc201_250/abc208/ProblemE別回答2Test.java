package abc.abc201_250.abc208;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemE別回答2Test extends TestBase {

	@Test
	void case1() {
		check("13 2", "5");
	}

	@Test
	void case2() {
		check("100 80", "99");
	}

	@Test
	void case3() {
		check("1000000000000000000 1000000000", "841103275147365677");
	}
}
