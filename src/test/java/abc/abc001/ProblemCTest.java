package abc.abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2750 628", "W 5");
	}

	@Test
	void case2() {
		check("161 8", "C 0");
	}

	@Test
	void case3() {
		check("3263 15", "NNW 1");
	}

	@Test
	void case4() {
		check("1462 1959", "SE 12");
	}

	@Test
	void case5() {
		check("1687 1029", "SSE 8");
	}

	@Test
	void case6() {
		check("2587 644", "WSW 5");
	}

	@Test
	void case7() {
		check("113 201", "NNE 3");
	}

	@Test
	void case8() {
		check("2048 16", "SSW 1");
	}
}
