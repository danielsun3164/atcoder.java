package abc.abc047;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("BBBWW", "1");
	}

	@Test
	void case2() {
		check("WWWWWW", "0");
	}

	@Test
	void case3() {
		check("WBWBWBWBWB", "9");
	}
}
