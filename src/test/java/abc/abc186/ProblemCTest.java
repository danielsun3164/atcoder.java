package abc.abc186;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("20", "17");
	}

	@Test
	void case2() {
		check("100000", "30555");
	}
}
