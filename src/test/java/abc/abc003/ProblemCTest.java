package abc.abc003;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "1000 1500", 1000.0d);
	}

	@Test
	void case2() {
		check("2 1\n" + "1000 1500", 750.0d);
	}

	@Test
	void case3() {
		check("10 5\n" + "2604 2281 3204 2264 2200 2650 2229 2461 2439 2211", 2820.03125d);
	}
}
