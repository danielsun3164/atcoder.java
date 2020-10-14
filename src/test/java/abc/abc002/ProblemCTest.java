package abc.abc002;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 0 3 0 2 5", 5.0d);
	}

	@Test
	void case2() {
		check("-1 -2 3 4 5 6", 2.0d);
	}

	@Test
	void case3() {
		check("298 520 903 520 4 663", 43257.5d);
	}
}
