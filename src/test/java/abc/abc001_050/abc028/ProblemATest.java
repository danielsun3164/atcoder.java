package abc.abc001_050.abc028;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("80", "Good");
	}

	@Test
	void case2() {
		check("100", "Perfect");
	}

	@Test
	void case3() {
		check("59", "Bad");
	}

	@Test
	void case4() {
		check("95", "Great");
	}
}
