package abc.abc012;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2013", "2 x 6" + LF + "3 x 4" + LF + "4 x 3" + LF + "6 x 2");
	}

	@Test
	void case2() {
		check("2024", "1 x 1");
	}
}
