package abc.abc051_100.abc055;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 6", "2");
	}

	@Test
	void case2() {
		check("12345 678901", "175897");
	}
}
